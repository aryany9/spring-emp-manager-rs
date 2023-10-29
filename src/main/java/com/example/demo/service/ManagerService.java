package com.example.demo.service;

import com.example.demo.model.Manager;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ManagerService {
    Optional<Manager> getManager(Long managerId);
}
