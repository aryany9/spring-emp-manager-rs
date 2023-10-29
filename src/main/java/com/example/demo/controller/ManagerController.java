package com.example.demo.controller;

import com.example.demo.model.Manager;
import com.example.demo.model.request.CreateManagerRequest;
import com.example.demo.model.response.CreateManagerResponse;
import com.example.demo.model.response.ManagerItemResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

public interface ManagerController {
    @RequestMapping(
            value = "/manager/{managerId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<ManagerItemResponse> getManager(@PathVariable("managerId") Long managerId);

    @RequestMapping(
            value = "/manager",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST
    )
    ResponseEntity<CreateManagerResponse> saveManager(@RequestBody CreateManagerRequest createManagerRequest);

    @RequestMapping(
            value = "/manager",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET
    )
    ResponseEntity<List<ManagerItemResponse>> getManagers();
}
