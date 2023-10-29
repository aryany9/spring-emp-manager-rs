package com.example.demo.exception;

public class ManagerNotFoundException extends RuntimeException{
    public ManagerNotFoundException(Long managerId){
        super("Manager with ID " + managerId+" Not Found");
    }
}
