package com.example.demo.controller;

import com.example.demo.model.request.LoginRequest;
import com.example.demo.model.request.RefreshTokenRequest;
import com.example.demo.model.response.LoginResponse;
import com.example.demo.model.response.TeamItemResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class UserAuthenticationApiControllerImpl implements UserAuthenticationApiController{
    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public ResponseEntity<LoginResponse> generateToken(RefreshTokenRequest refreshTokenRequest) {
        return null;
    }
}
