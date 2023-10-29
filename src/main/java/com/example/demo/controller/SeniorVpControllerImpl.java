package com.example.demo.controller;

import com.example.demo.model.SeniorVP;
import com.example.demo.model.request.CreateSeniorVPRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class SeniorVpControllerImpl implements SeniorVpController {
    @Override
    public ResponseEntity<Optional<SeniorVP>> getTeam(Long seniorVpId) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<SeniorVP>> addTeam(CreateSeniorVPRequest seniorVPRequest) {
        return null;
    }

    @Override
    public ResponseEntity<List<SeniorVP>> getAllTeam() {
        return null;
    }
}
