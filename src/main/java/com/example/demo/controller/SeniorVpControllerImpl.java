package com.example.demo.controller;

import com.example.demo.model.SeniorVP;
import com.example.demo.model.request.AddSeniorVPRequest;
import com.example.demo.model.response.SeniorVpItemResponse;
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
    public ResponseEntity<SeniorVpItemResponse> getTeam(Long seniorVpId) {
        return ResponseEntity.ok(seniorVpService.getSeniorVp(seniorVpId));
    }

    @Override
    public ResponseEntity<SeniorVpItemResponse> createSeniorVp(AddSeniorVPRequest seniorVPRequest) {
        return ResponseEntity.ok(seniorVpService.addSeniorVp(seniorVPRequest));
    }

    @Override
    public ResponseEntity<List<SeniorVpItemResponse>> getAllTeam() {
        return ResponseEntity.ok(seniorVpService.getAllSeniorVp());
    }
}
