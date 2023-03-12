package com.example.demo.service;

import com.example.demo.dl.api.ICounter;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
    private ICounter count;
    public CounterService(ICounter count){
        this.count = count;
    }

    public void increment(){
        count.increment();
    }
    public long getCount(){
        return count.getCount();
    }
}
