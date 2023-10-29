package com.example.demo.controller;

import com.example.demo.model.Team;
import com.example.demo.model.request.CreateTeamRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface TeamController {
    @RequestMapping(
            value = "/team/{teamId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<Optional<Team>> getTeam(@PathVariable("teamId") Long teamId);

    @RequestMapping(
            value = "/team",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    ResponseEntity<Optional<Team>> addTeam(@RequestBody CreateTeamRequest teamRequest);

    @RequestMapping(
            value = "/team",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<List<Team>> getAllTeam();

}
