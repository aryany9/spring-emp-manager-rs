package com.example.demo.controller;

import com.example.demo.model.Manager;
import com.example.demo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class ManagerControllerImpl implements ManagerController{

    @Autowired
    private ManagerService managerService;
    @Override
    public ResponseEntity<Optional<Manager>> getManager(Long managerId) {
        return ResponseEntity.ok(managerService.getManager(managerId));
    }
}
