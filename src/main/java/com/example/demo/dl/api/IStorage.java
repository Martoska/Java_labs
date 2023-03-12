package com.example.demo.dl.api;
import com.example.demo.core.dtos.CharacterOfNumberDTO;
import java.util.Map;

public interface IStorage {
    void save(int param1, CharacterOfNumberDTO result);
    Map<Integer, CharacterOfNumberDTO> getAll();
    void saveAll(Map<Integer, CharacterOfNumberDTO> map);
}
