package com.example.demo.service;

import com.example.demo.core.dtos.SourceAndResulDTO;
import com.example.demo.core.dtos.StatisticDTO;
import com.example.demo.dl.api.IStorage;
import com.example.demo.core.dtos.CharacterOfNumberDTO;
import com.example.demo.dl.api.IStorageRepository;
import com.example.demo.dl.entites.SourceAndResultEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class ParityAndSimplicityService {

    private final IStorage storage;
    private final CounterService counter;
    private final StatisticService statisticService;
    private final IStorageRepository repository;

    public ParityAndSimplicityService(IStorage storage, CounterService service,
                                      StatisticService statisticService,
                                      IStorageRepository repository) {
        this.storage = storage;
        this.counter = service;
        this.statisticService = statisticService;
        this.repository = repository;
    }

    public boolean isEven(int value) {
        return value % 2 == 0;
    }

    public boolean isPrime(int value) {
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public CharacterOfNumberDTO countResult(int value) {
        counter.increment();
        CharacterOfNumberDTO characterOfNumber = new CharacterOfNumberDTO(isPrime(value), isEven(value));
        CompletableFuture.runAsync(()->storage.save(value, characterOfNumber));

        SourceAndResultEntity entity = new SourceAndResultEntity(
                value, characterOfNumber.isEven(),characterOfNumber.isPrime());
        CompletableFuture.runAsync(()->repository.save(entity));
        return characterOfNumber;
    }

    public long getCount(){
        return counter.getCount();
    }

    public List<SourceAndResulDTO> getAll(){
        /*return storage.getAll()
                .entrySet()
                .stream()
                .map(entry -> new SourceAndResulDTO(entry.getKey(), entry.getValue()))
                .toList(); */
        return repository.findAll()
                .stream()
                .map(entity -> new SourceAndResulDTO(entity.getValue(),
                        new CharacterOfNumberDTO(entity.isEven(), entity.isPrime())))
                .toList();
    }

    public StatisticDTO saveAll(List<Integer> list){
        Map<Integer, CharacterOfNumberDTO> map = new HashMap<>();
        list.forEach(integer -> map.put(integer, countResult(integer)));

        CompletableFuture.runAsync(()->storage.saveAll(map));

        CompletableFuture.runAsync(()-> repository.saveAll(list.stream()
                .map(i -> new SourceAndResultEntity(i, this.isEven(i), this.isPrime(i))).toList()));

        return statisticService.getStatistic(list);
    }
}

