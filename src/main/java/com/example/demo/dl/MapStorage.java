package com.example.demo.dl;

import com.example.demo.dl.api.IStorage;
import com.example.demo.core.dtos.CharacterOfNumber;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Component
public class MapStorage implements IStorage {
    private Map<Integer, CharacterOfNumber> map = new ConcurrentHashMap<>(); // потокобезопасно
    @Override
    public void save(int param1, CharacterOfNumber result) {
        map.put(param1, result);
    }
    @Override
    public Map<Integer, CharacterOfNumber> getAll() {
        return Collections.unmodifiableMap(map);            //возвращает неизменяемый вид указанной карты
    }

    @Override
    public void saveAll(Map<Integer, CharacterOfNumber> map) {
        this.map.putAll(map);
    }
}
