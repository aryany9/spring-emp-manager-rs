package com.example.demo.service;

import com.example.demo.model.request.AddTeamRequest;
import com.example.demo.model.response.TeamItemResponse;

import java.util.List;

public interface TeamService {

    TeamItemResponse addTeam(AddTeamRequest addTeamRequest);

    TeamItemResponse getTeam(Long id);

    List<TeamItemResponse> getAllTeam();
}
