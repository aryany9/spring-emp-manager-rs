package com.example.demo.service;

import com.example.demo.model.request.AddTeamRequest;
import com.example.demo.model.response.AddTeamResponse;

public interface TeamService {
    AddTeamResponse addTeam(AddTeamRequest addTeamRequest);
}
