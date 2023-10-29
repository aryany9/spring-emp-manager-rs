package com.example.demo.controller;


import com.example.demo.model.request.AddEmployeeRequest;
import com.example.demo.model.response.EmployeeItemResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface EmployeeController {
    @RequestMapping(
            value = "/employee",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    ResponseEntity<EmployeeItemResponse> addEmployee(@RequestBody AddEmployeeRequest employeeRequest);

    @RequestMapping(
            value = "/employee",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<List<EmployeeItemResponse>> getAllEmployee();

    @RequestMapping(
            value = "/employee/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    ResponseEntity<EmployeeItemResponse> getEmployee(@PathVariable Long id);

}
