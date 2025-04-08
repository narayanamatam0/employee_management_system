package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmployeeRepo;
import com.example.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployeeById(Long id, Employee employee) {
        Employee existingEmployee = employeeRepo.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setEmailId(employee.getEmailId());
            return employeeRepo.save(existingEmployee);
        }
        return null; // or throw an exception if not found
    }
}