package com.example.delivery.services;

import com.example.delivery.models.Employee;
import com.example.delivery.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public int saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public int updateEmployee(Employee employee) {
        return employeeRepository.update(employee);
    }

    public int deleteEmployee(Long id) {
        return employeeRepository.deleteById(id);
    }
}
