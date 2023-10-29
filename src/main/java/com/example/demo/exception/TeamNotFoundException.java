package com.example.demo.exception;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException(Long teamId) {
        super("Team not found for id: " + teamId);
    }
}
