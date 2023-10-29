package com.example.demo.service;


import com.example.demo.model.request.AddEmployeeRequest;
import com.example.demo.model.response.EmployeeItemResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeItemResponse addEmployee(AddEmployeeRequest addEmployeeRequest);

    List<EmployeeItemResponse> getAllEmployee();

    EmployeeItemResponse getEmployee(Long employeeId);
}
