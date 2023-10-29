package com.example.demo.service;

import com.example.demo.model.request.AddSeniorVPRequest;
import com.example.demo.model.response.SeniorVpItemResponse;

import java.util.List;

public interface SeniorVpService {
    SeniorVpItemResponse addSeniorVp(AddSeniorVPRequest addSeniorVPRequest);

    List<SeniorVpItemResponse> getAllSeniorVp();

    SeniorVpItemResponse getSeniorVp(Long seniorVpId);
}
