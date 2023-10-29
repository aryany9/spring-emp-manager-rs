package com.example.demo.controller;

import com.example.demo.model.request.AddEmployeeRequest;
import com.example.demo.model.response.EmployeeItemResponse;
import com.example.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class EmployeeControllerImpl implements EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Override
    public ResponseEntity<EmployeeItemResponse> addEmployee(AddEmployeeRequest employeeRequest) {
        return ResponseEntity.ok(employeeService.addEmployee(employeeRequest));
    }

    @Override
    public ResponseEntity<List<EmployeeItemResponse>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @Override
    public ResponseEntity<EmployeeItemResponse> getEmployee(Long id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }
}
