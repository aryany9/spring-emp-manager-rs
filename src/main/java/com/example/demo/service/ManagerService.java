package com.example.demo.service;

import com.example.demo.model.Manager;
import com.example.demo.model.SeniorVP;
import com.example.demo.model.Team;
import com.example.demo.model.request.CreateManagerRequest;
import com.example.demo.model.response.CreateManagerResponse;

import java.util.Optional;


public interface ManagerService {
    Optional<Manager> getManager(Long managerId);

    CreateManagerResponse createManager(CreateManagerRequest createManagerRequest);

    Team getTeam(Long teamId);

    SeniorVP getSeniorVp(Long seniorVP);
}
