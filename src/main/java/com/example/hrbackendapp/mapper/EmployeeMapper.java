package com.example.hrbackendapp.mapper;


import com.example.hrbackendapp.DTO.EmployeeDTO;
import com.example.hrbackendapp.model.Employee;


public interface EmployeeMapper {


    EmployeeDTO employeeToDTO(Employee employee);
    Employee empDTOToEmp(EmployeeDTO employeeDTO);

}
