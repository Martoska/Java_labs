package com.example.demo.dl.entites;

import com.example.demo.core.dtos.SourceAndResulDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "storage", schema = "labs")
public class SourceAndResultEntity {
    @Id
    private Integer value;
    private boolean even;
    private boolean prime;

    public SourceAndResultEntity(int value, boolean even, boolean prime) {
        this.value = value;
        this.even = even;
        this.prime = prime;
    }

    public SourceAndResultEntity() {
    }

    public SourceAndResultEntity(SourceAndResulDTO dto) {
        this.value = dto.getSource();
        this.even = dto.getResult().isEven();
        this.prime = dto.getResult().isPrime();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isEven() {
        return even;
    }

    public void setEven(boolean even) {
        this.even = even;
    }

    public boolean isPrime() {
        return prime;
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }
}
