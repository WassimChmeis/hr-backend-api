package com.example.hrbackendapp.controller;


import com.example.hrbackendapp.DTO.DepartmentDto;
import com.example.hrbackendapp.DTO.EmployeeDTO;
import com.example.hrbackendapp.model.Department;
import com.example.hrbackendapp.model.Employee;
import com.example.hrbackendapp.service.DepartmentService;
import com.example.hrbackendapp.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/employee/manage/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;


    @PatchMapping (value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getEmployeeByMapping(@PathVariable int id,@RequestBody Map<String, Object> emplyeeDTO){

        try{
            employeeService.updateEmployeeData(id,emplyeeDTO);
            return ResponseEntity.ok("Employee Updated Successfully!");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }

    @PostMapping(value = "add")
    public ResponseEntity<String> createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
       return employeeService.saveNewEmployee(employeeDTO);
    }


    @PostMapping({"department/","department"})
    public ResponseEntity<Department> defineDepartment(@RequestBody DepartmentDto department){
        return departmentService.createDepartment(department);
    }




    @GetMapping(value = "{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable int id){
        return employeeService.getById(id);
    }

    @GetMapping(value = "department/{id}")
    public List<EmployeeDTO> getAllEmployeesByDepartment(@PathVariable int id){

        return employeeService.GetAllByDepartmentId(id);


    }
}
