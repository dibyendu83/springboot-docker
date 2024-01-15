package com.dibs.kubetest.service;

import com.dibs.kubetest.dao.EmployeeRepository;
import com.dibs.kubetest.dto.Employee;
import com.dibs.kubetest.exception.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee fetchByEmpId(String empId) {
        Assert.notNull(empId, "Employee Id can not be null");
        return repository.findById(Long.parseLong(empId)).orElseThrow(() ->
            new ResourceNotFoundException("Employee Id does not exist"));
    }

    public List<Employee> findAllEmployee() {
        return repository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }
}
