package com.example.demo.core.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
@JsonPropertyOrder({"number", "even", "prime"})         //порядок вывода
public class SourceAndResulDTO {
    @JsonProperty("number")                             //для указания имени
    private int source;
    @JsonUnwrapped
    private CharacterOfNumberDTO result;

    public SourceAndResulDTO(int source, CharacterOfNumberDTO result) {
        this.source = source;
        this.result = result;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public CharacterOfNumberDTO getResult() {
        return result;
    }

    public void setResult(CharacterOfNumberDTO result) {
        this.result = result;
    }
}
