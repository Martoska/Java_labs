package com.example.demo.core.dtos;

public class CharacterOfNumberDTO {
    private boolean IsPrime;
    private boolean IsEven;

    public CharacterOfNumberDTO(boolean isPrime, boolean isEven) {
        IsPrime = isPrime;
        IsEven = isEven;
    }
    public boolean isPrime() {
        return IsPrime;
    }
    public boolean isEven() {
        return IsEven;
    }
}
