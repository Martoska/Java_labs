package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.dl.api.IStorage;
import com.example.demo.dl.api.IStorageRepository;

public class ParityAndSimplicityServiceTest {

    private IStorage storage;
    private CounterService counter;
    private StatisticService statisticService;
    private IStorageRepository repository;
    private ParityAndSimplicityService service;

    @BeforeEach
    public void setUp() {
        storage = mock(IStorage.class);
        counter = mock(CounterService.class);
        statisticService = mock(StatisticService.class);
        repository = mock(IStorageRepository.class);
        service = new ParityAndSimplicityService(storage, counter, statisticService, repository);
    }

    @Test
    public void testIsEvenWithEvenValue() {
        assertTrue(service.isEven(2));
    }

    @Test
    public void testIsEvenWithOddValue() {
        assertFalse(service.isEven(3));
    }

    @Test
    public void testIsPrimeWithPrimeValue() {
        assertTrue(service.isPrime(7));
    }

    @Test
    public void testIsPrimeWithCompositeValue() {
        assertFalse(service.isPrime(9));
    }

}