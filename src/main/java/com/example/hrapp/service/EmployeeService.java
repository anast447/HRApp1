package com.example.hrapp.service;

import com.example.hrapp.model.Employee;
import com.example.hrapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Employee create(Employee employee) {
        return repo.save(employee);
    }

    public Employee update(Long id, Employee employee) {
        employee.setId(id);
        return repo.save(employee);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
