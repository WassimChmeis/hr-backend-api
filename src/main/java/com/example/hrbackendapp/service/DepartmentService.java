package com.example.hrbackendapp.service;

import com.example.hrbackendapp.model.Department;
import com.example.hrbackendapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;


    public ResponseEntity<Department> createDepartment(Department department) {
        try {
            if (department!=null){
                Department savedDepartment = departmentRepository.save(department);
                return ResponseEntity.ok().body(savedDepartment);
            }
            else {
                return ResponseEntity.badRequest().build();
            }
        }
        catch (Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
