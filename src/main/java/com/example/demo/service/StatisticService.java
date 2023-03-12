package com.example.demo.service;

import com.example.demo.core.dtos.StatisticDTO;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
@Component
public class StatisticService {

    private int findMin(List<Integer> list){
        return list.stream().min(Comparator.naturalOrder())
                .orElseThrow(()->new NullPointerException("list is empty"));
    }

    private int findMax(List<Integer> list){
        return list.stream().max(Comparator.naturalOrder())
                .orElseThrow(()->new NullPointerException("list is empty"));
    }

    private int findMiddle(List<Integer> list){
        return list.stream().sorted().skip(list.size()/2).findFirst()
                .orElseThrow(()->new NullPointerException("list is empty"));
    }

    public StatisticDTO getStatistic(List<Integer> list){
        return new StatisticDTO(
                findMin(list),
                findMax(list),
                findMiddle(list)
        );
    }
}
