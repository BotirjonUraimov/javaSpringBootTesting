package com.clean.code.springboot.service;

import com.clean.code.springboot.domain.Employee;
import com.clean.code.springboot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return  employeeRepository.findById(id).get();
    }
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }
    public List<Employee> findByNameAndLastName(String name, String lastname) {
        return employeeRepository.findByNameAndLastName(name, lastname);
    }

}
