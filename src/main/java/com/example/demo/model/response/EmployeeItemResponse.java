package com.example.demo.model.response;

import com.example.demo.model.Manager;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployeeItemResponse {
    @JsonProperty
    private String firstName;

    @JsonProperty
    private Long id;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private String department;

    @JsonProperty
    private String designation;

    @JsonProperty
    private String technology;

    @JsonProperty
    private Long managerId;
}
