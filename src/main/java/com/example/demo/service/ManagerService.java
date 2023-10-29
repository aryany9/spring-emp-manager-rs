package com.example.demo.service;

import com.example.demo.model.Manager;
import com.example.demo.model.SeniorVP;
import com.example.demo.model.Team;
import com.example.demo.model.request.CreateManagerRequest;
import com.example.demo.model.response.CreateManagerResponse;
import com.example.demo.model.response.ManagerItemResponse;

import java.util.List;
import java.util.Optional;


public interface ManagerService {
    ManagerItemResponse getManager(Long managerId);

    CreateManagerResponse createManager(CreateManagerRequest createManagerRequest);

    Team getTeam(Long teamId);

    SeniorVP getSeniorVp(Long seniorVP);

    List<ManagerItemResponse> getManagers();
}
