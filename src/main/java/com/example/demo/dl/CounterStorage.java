package com.example.demo.dl;
import com.example.demo.dl.api.ICounter;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;
@Component
public class CounterStorage implements ICounter {
    private AtomicLong counter = new AtomicLong();      //для потокобезопасности и синхронизации
    @Override
    public void increment() {
        counter.incrementAndGet();
    }
    @Override
    public long getCount() {
        return counter.get();
    }
}
