package com.example.hrbackendapp.repository;

import com.example.hrbackendapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //id to be Integer
    List<Employee> findEmployeesByDepartmentId(int id);
}