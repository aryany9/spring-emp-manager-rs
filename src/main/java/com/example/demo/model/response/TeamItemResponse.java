package com.example.demo.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TeamItemResponse {
    @JsonProperty
    private String teamName;

    @JsonProperty
    private Long teamId;

    @JsonProperty
    private String description;
}
