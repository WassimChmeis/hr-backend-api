package com.example.hrbackendapp.repository;

import com.example.hrbackendapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}