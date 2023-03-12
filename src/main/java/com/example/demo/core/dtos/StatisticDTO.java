package com.example.demo.core.dtos;

public class StatisticDTO {
    private int minValue;
    private int maxValue;
    private int middleValue;

    public StatisticDTO(int minValue, int maxValue, int middleValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.middleValue = middleValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMiddleValue() {
        return middleValue;
    }

    public void setMiddleValue(int middleValue) {
        this.middleValue = middleValue;
    }
}
