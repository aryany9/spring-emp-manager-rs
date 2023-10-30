package com.example.demo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;;

import feign.form.FormProperty;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationAccessTokenRequest {

    @FormProperty("grant_type")
    @JsonProperty("grant_type")
    private String grantType;

    @FormProperty("client_secret")
    @JsonProperty("client_secret")
    private String clientSecret;

    @FormProperty("client_id")
    @JsonProperty("client_id")
    private String clientId;

    @FormProperty("refresh_token")
    @JsonProperty("refresh_token")
    private String refreshToken;
}
