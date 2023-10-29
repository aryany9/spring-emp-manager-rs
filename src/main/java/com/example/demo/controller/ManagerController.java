package com.example.demo.controller;

import com.example.demo.model.Manager;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

public interface ManagerController {
    @RequestMapping(
            value = "/manager/{managerId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<Optional<Manager>> getManager(Long id);
}
