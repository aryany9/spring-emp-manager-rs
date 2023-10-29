package com.example.demo.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long employeeId){
        super("Employee not found " + employeeId);
    }
}
