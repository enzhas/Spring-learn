package com.example.delivery.controllers;

import com.example.delivery.models.Employee;
import com.example.delivery.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/single")
    public Optional<Employee> getEmployeeById(@RequestParam Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/create")
    public int createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/update")
    public int updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/status/get")
    public String getEmployeeStatusById(@RequestParam Long id) {
        return employeeService.getEmployeeStatus(id);
    }

    @PostMapping("/status/update")
    public int updateEmployeeSatus(@RequestParam Long id) {
        return employeeService.updateEmployeeStatus(id);
    }

    @PostMapping("/delete")
    public int deleteEmployee(@RequestParam Long id) {
        return employeeService.deleteEmployee(id);
    }
}
