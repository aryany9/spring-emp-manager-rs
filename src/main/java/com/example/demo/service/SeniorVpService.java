package com.example.demo.service;

import com.example.demo.model.request.AddSeniorVPRequest;
import com.example.demo.model.response.AddSeniorVpResponse;

public interface SeniorVpService {
    AddSeniorVpResponse addSeniorVp(AddSeniorVPRequest addSeniorVPRequest);
}
