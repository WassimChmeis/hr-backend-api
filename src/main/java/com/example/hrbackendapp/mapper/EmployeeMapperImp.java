package com.example.hrbackendapp.mapper;

import com.example.hrbackendapp.DTO.EmployeeDTO;
import com.example.hrbackendapp.model.Employee;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;


@Component
public class EmployeeMapperImp implements EmployeeMapper{
    @Override
    public EmployeeDTO employeeToDTO(Employee employee) {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(employee.getName());
        employeeDTO.setId(employee.getId());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setAddress(employee.getAddress());
        employeeDTO.setDepartmentId(employee.getDepartmentId());
        return employeeDTO;
    }

    @Override
    public Employee empDTOToEmp(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setAddress(employeeDTO.getAddress());
        employee.setDepartmentId(employeeDTO.getDepartmentId());
        return employee;
    }
}
