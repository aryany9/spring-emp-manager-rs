package com.example.demo.controller;

import com.example.demo.model.request.AddTeamRequest;
import com.example.demo.model.response.TeamItemResponse;
import com.example.demo.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class TeamControllerImpl implements TeamController {
    @Autowired
    TeamService teamService;

    @Override
    public ResponseEntity<TeamItemResponse> getTeam(Long teamId) {
        return ResponseEntity.ok( teamService.getTeam(teamId));
    }

    @Override
    public ResponseEntity<TeamItemResponse> addTeam(AddTeamRequest teamRequest) {

        return ResponseEntity.ok( teamService.addTeam(teamRequest));
    }

    @Override
    public ResponseEntity<List<TeamItemResponse>> getAllTeam() {
        return ResponseEntity.ok( teamService.getAllTeam());
    }
}
