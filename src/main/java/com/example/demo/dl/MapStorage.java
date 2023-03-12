package com.example.demo.dl;

import com.example.demo.dl.api.IStorage;
import com.example.demo.core.dtos.CharacterOfNumberDTO;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Component
public class MapStorage implements IStorage {
    private Map<Integer, CharacterOfNumberDTO> map = new ConcurrentHashMap<>(); // потокобезопасно
    @Override
    public void save(int param1, CharacterOfNumberDTO result) {
        map.put(param1, result);
    }
    @Override
    public Map<Integer, CharacterOfNumberDTO> getAll() {
        return Collections.unmodifiableMap(map);            //возвращает неизменяемый вид указанной карты
    }

    @Override
    public void saveAll(Map<Integer, CharacterOfNumberDTO> map) {
        this.map.putAll(map);
    }
}
