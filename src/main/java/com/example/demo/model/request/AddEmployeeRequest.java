package com.example.demo.model.request;

import com.example.demo.model.Manager;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeRequest {
    @JsonProperty
    private String firstName;

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
