package com.example.demo.controller;

import com.example.demo.model.Team;
import com.example.demo.model.request.CreateTeamRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class TeamControllerImpl implements TeamController {
    @Override
    public ResponseEntity<Optional<Team>> getTeam(Long teamId) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<Team>> addTeam(CreateTeamRequest teamRequest) {
        return null;
    }

    @Override
    public ResponseEntity<List<Team>> getAllTeam() {
        return null;
    }
}
