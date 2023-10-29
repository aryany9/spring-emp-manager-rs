package com.example.demo.service;

import com.example.demo.exception.ManagerNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.Manager;
import com.example.demo.model.request.AddEmployeeRequest;
import com.example.demo.model.response.EmployeeItemResponse;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public EmployeeItemResponse addEmployee(AddEmployeeRequest addEmployeeRequest) {
        Employee employee = new Employee();
        employee.setFirstName(addEmployeeRequest.getFirstName());
        employee.setLastName(addEmployeeRequest.getLastName());
        employee.setDepartment(addEmployeeRequest.getDepartment());
        employee.setDesignation(addEmployeeRequest.getDesignation());
        employee.setTechnology(addEmployeeRequest.getTechnology());
        employee.setManager(getManagerById(addEmployeeRequest.getManagerId()));


        Employee result = employeeRepository.save(employee);
        return getEmployeeItemResponse(result);
    }

    private static EmployeeItemResponse getEmployeeItemResponse(Employee result) {
        EmployeeItemResponse employeeItemResponse = new EmployeeItemResponse();
        employeeItemResponse.setId(result.getId());
        employeeItemResponse.setFirstName(result.getFirstName());
        employeeItemResponse.setLastName(result.getLastName());
        employeeItemResponse.setDepartment(result.getDepartment());
        employeeItemResponse.setDesignation(result.getDesignation());
        employeeItemResponse.setManagerId(result.getManager().getId());
        employeeItemResponse.setTechnology(result.getTechnology());
        return employeeItemResponse;
    }

    public Manager getManagerById(Long managerId) {
//        log.info("Team ID: {}", teamId.toString());
        return managerRepository.findById(managerId)
                .orElseThrow(() -> new ManagerNotFoundException(managerId));
    }

    @Override
    public List<EmployeeItemResponse> getAllEmployee() {
        List<EmployeeItemResponse> response = new ArrayList<EmployeeItemResponse>();
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            EmployeeItemResponse itemResponse = new EmployeeItemResponse();
            itemResponse.setId(employee.getId());
            itemResponse.setFirstName(employee.getFirstName());
            itemResponse.setLastName(employee.getLastName());
            itemResponse.setDepartment(employee.getDepartment());
            itemResponse.setDesignation(employee.getDesignation());
            itemResponse.setManagerId(employee.getManager().getId());
            itemResponse.setTechnology(employee.getTechnology());
            response.add(itemResponse);
        }
        return response;
    }

    @Override
    public EmployeeItemResponse getEmployee(Long employeeId) {
        EmployeeItemResponse employeeItemResponse = new EmployeeItemResponse();
        Optional<Employee> result = employeeRepository.findById(employeeId);
        employeeItemResponse.setId(result.get().getId());
        employeeItemResponse.setFirstName(result.get().getFirstName());
        employeeItemResponse.setLastName(result.get().getLastName());
        employeeItemResponse.setTechnology(result.get().getTechnology());
        employeeItemResponse.setDesignation(result.get().getDesignation());
        employeeItemResponse.setDepartment(result.get().getDepartment());
        employeeItemResponse.setManagerId(result.get().getManager().getId());
        return employeeItemResponse;
    }
}
