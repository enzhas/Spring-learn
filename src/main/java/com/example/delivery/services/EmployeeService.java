package com.example.delivery.services;

import com.example.delivery.models.Employee;
import com.example.delivery.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.getById(id);
    }

    public int saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public int updateEmployee(Employee employee) {
        return employeeRepository.update(employee);
    }

    public String getEmployeeStatus(Long id) {
        Optional<Employee> employee = employeeRepository.getById(id);
        if (employee.isPresent()) {
            return employee.get().getStatus();
        }
        return "Not found";
    }
    public int updateEmployeeStatus(Long id) {
        return employeeRepository.updateStatus(id);
    }

    public int deleteEmployee(Long id) {
        return employeeRepository.deleteById(id);
    }
}
