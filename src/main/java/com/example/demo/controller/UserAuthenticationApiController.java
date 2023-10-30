package com.example.demo.controller;

import com.example.demo.model.request.AddTeamRequest;
import com.example.demo.model.request.LoginRequest;
import com.example.demo.model.request.RefreshTokenRequest;
import com.example.demo.model.response.LoginResponse;
import com.example.demo.model.response.TeamItemResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UserAuthenticationApiController {
    @RequestMapping(
            value = "public/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest);

    @RequestMapping(
            value = "/public/user/refreshtoken",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    ResponseEntity<LoginResponse> generateToken(
            @Validated @RequestBody RefreshTokenRequest refreshTokenRequest);
}
