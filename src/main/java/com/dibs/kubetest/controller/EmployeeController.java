package com.dibs.kubetest.controller;

import com.dibs.kubetest.dto.Employee;
import com.dibs.kubetest.service.EmployeeService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("api/v1/employees")
    public List<Employee> fetchAll() {
        return employeeService.findAllEmployee();
    }

    @GetMapping("api/v1/employee/{id}")
    public Employee fetchByEmpId(@PathVariable String id) {
        log.info("Fetching employee records for employee id = {} ", id);
        return employeeService.fetchByEmpId(id);
    }

    @PostMapping("api/v1/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody @Validated Employee employee){
        return  employeeService.createEmployee(employee);
    }
}
