package com.example.demo.controller;

import com.example.demo.model.Manager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface ManagerController {
    ResponseEntity<Manager> getManagerWithTeams(@PathVariable("managerId") Long managerId);
}
