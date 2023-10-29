package com.example.demo.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddSeniorVpResponse {
    @JsonProperty
    private String firstName;

    @JsonProperty
    private Long id;

    @JsonProperty
    private String lastName;
}
