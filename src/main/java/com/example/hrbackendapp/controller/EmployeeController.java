package com.example.hrbackendapp.controller;


import com.example.hrbackendapp.model.Employee;
import com.example.hrbackendapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee/manage/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;



    @GetMapping(value = "{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        return employeeService.getById(id);
    }
}
