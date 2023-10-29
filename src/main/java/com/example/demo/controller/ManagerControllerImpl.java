package com.example.demo.controller;

import com.example.demo.model.Manager;
import org.springframework.http.ResponseEntity;

public class ManagerControllerImpl implements ManagerController{
    @Override
    public ResponseEntity<Manager> getManagerWithTeams(Long managerId) {
        return null;
    }
}
