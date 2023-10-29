package com.example.demo.controller;

import com.example.demo.model.SeniorVP;
import com.example.demo.model.Team;
import com.example.demo.model.request.CreateSeniorVPRequest;
import com.example.demo.model.request.CreateTeamRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

public interface SeniorVpController {

    @RequestMapping(
            value = "/seniorVp/{seniorVpId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<Optional<SeniorVP>> getTeam(@PathVariable("seniorVpId") Long seniorVpId);

    @RequestMapping(
            value = "/seniorVp",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    ResponseEntity<Optional<SeniorVP>> addTeam(@RequestBody CreateSeniorVPRequest seniorVPRequest);

    @RequestMapping(
            value = "/seniorVp",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<List<SeniorVP>> getAllTeam();
}
