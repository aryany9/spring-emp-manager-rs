package com.example.demo.controller;

import com.example.demo.model.Team;
import com.example.demo.model.request.AddTeamRequest;
import com.example.demo.model.response.AddTeamResponse;
import com.example.demo.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class TeamControllerImpl implements TeamController {
    @Autowired
    TeamService teamService;

    @Override
    public ResponseEntity<Optional<Team>> getTeam(Long teamId) {
        return null;
    }

    @Override
    public ResponseEntity<AddTeamResponse> addTeam(AddTeamRequest teamRequest) {

        return ResponseEntity.ok( teamService.addTeam(teamRequest));
    }

    @Override
    public ResponseEntity<List<Team>> getAllTeam() {
        return null;
    }
}
