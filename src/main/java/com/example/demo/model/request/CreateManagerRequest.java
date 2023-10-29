package com.example.demo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateManagerRequest {

    @JsonProperty
    private String fName;

    @JsonProperty
    private String lName;

    @JsonProperty
    private Long seniorVpId;

    @JsonProperty
    private Long teamId;
}
