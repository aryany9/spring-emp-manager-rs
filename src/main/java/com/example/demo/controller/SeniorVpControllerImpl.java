package com.example.demo.controller;

import com.example.demo.model.SeniorVP;
import com.example.demo.model.request.AddSeniorVPRequest;
import com.example.demo.model.response.AddSeniorVpResponse;
import com.example.demo.service.SeniorVpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class SeniorVpControllerImpl implements SeniorVpController {
    @Autowired
    SeniorVpService seniorVpService;
    @Override
    public ResponseEntity<Optional<SeniorVP>> getTeam(Long seniorVpId) {
        return null;
    }

    @Override
    public ResponseEntity<AddSeniorVpResponse> createSeniorVp(AddSeniorVPRequest seniorVPRequest) {
        return ResponseEntity.ok(seniorVpService.addSeniorVp(seniorVPRequest));
    }

    @Override
    public ResponseEntity<List<SeniorVP>> getAllTeam() {
        return null;
    }
}
