package com.example.demo.dl.api;

import com.example.demo.dl.entites.SourceAndResultEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStorageRepository extends CrudRepository<SourceAndResultEntity,Integer> {
    List<SourceAndResultEntity> findAll();
}
