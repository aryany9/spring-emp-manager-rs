package com.example.demo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateManagerRequest {

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private Long seniorVpId;

    @NonNull
    @JsonProperty
    private Long teamId;
}
