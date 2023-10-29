package com.example.demo.exception;

public class SeniorVPNotFoundException extends RuntimeException {
    public SeniorVPNotFoundException(Long seniorVpId){
        super("Senior VP not found" + seniorVpId);
    }
}
