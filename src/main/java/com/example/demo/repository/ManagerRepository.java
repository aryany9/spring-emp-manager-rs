package com.example.demo.repository;

import com.example.demo.model.Manager;
import com.example.demo.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Optional<Manager> findManagerById(Long managerId);
}
