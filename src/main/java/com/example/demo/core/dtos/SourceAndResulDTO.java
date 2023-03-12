package com.example.demo.core.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
@JsonPropertyOrder({"number", "even", "prime"})
public class SourceAndResulDTO {
    @JsonProperty("number")
    private int source;
    @JsonUnwrapped
    private CharacterOfNumber result;

    public SourceAndResulDTO(int source, CharacterOfNumber result) {
        this.source = source;
        this.result = result;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public CharacterOfNumber getResult() {
        return result;
    }

    public void setResult(CharacterOfNumber result) {
        this.result = result;
    }
}
