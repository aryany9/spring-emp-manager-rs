package com.example.demo.controller;

import com.example.demo.model.request.AddTeamRequest;
import com.example.demo.model.response.TeamItemResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TeamController {
    @RequestMapping(
            value = "/team/{teamId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<TeamItemResponse> getTeam(@PathVariable("teamId") Long teamId);

    @RequestMapping(
            value = "/team",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    ResponseEntity<TeamItemResponse> addTeam(@RequestBody AddTeamRequest teamRequest);

    @RequestMapping(
            value = "/team",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<List<TeamItemResponse>> getAllTeam();

}
