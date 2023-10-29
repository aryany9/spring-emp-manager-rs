package com.example.demo.controller;

import com.example.demo.model.SeniorVP;
import com.example.demo.model.request.AddSeniorVPRequest;
import com.example.demo.model.response.SeniorVpItemResponse;
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
    ResponseEntity<SeniorVpItemResponse> getTeam(@PathVariable("seniorVpId") Long seniorVpId);

    @RequestMapping(
            value = "/seniorVp",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    ResponseEntity<SeniorVpItemResponse> createSeniorVp(@RequestBody AddSeniorVPRequest seniorVPRequest);

    @RequestMapping(
            value = "/seniorVp",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<List<SeniorVpItemResponse>> getAllTeam();
}
