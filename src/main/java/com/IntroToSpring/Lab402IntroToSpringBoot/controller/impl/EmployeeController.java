package com.IntroToSpring.Lab402IntroToSpringBoot.controller.impl;

import com.IntroToSpring.Lab402IntroToSpringBoot.model.Employee;
import com.IntroToSpring.Lab402IntroToSpringBoot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllDoctors() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getDoctorById(@PathVariable Long id) {
        return employeeRepository.findById(id);
    }

    @GetMapping("/employees/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status) {
        return employeeRepository.findByStatus(status);
    }

    @GetMapping("/employees/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department) {
        return employeeRepository.findByDepartment(department);
    }

}