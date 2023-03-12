package com.example.demo.dl.api;
import com.example.demo.core.dtos.CharacterOfNumber;
import java.util.Map;

public interface IStorage {
    void save(int param1, CharacterOfNumber result);
    Map<Integer, CharacterOfNumber> getAll();
    void saveAll(Map<Integer, CharacterOfNumber> map);
}
