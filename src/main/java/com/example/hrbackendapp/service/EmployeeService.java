package com.example.hrbackendapp.service;


import com.example.hrbackendapp.DTO.EmployeeDTO;
import com.example.hrbackendapp.mapper.EmployeeMapper;
import com.example.hrbackendapp.mapper.EmployeeMapperImp;
import com.example.hrbackendapp.model.Employee;
import com.example.hrbackendapp.repository.EmployeeRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapperImp employeeMapper;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BusinessService businessService;

    public List<EmployeeDTO> GetAllByDepartmentId(int id) {
        List<Employee> employeeList = employeeRepository.findEmployeesByDepartmentId(id);
        List<EmployeeDTO> employeeDTOS = employeeList.stream().map(employeeMapper::employeeToDTO).collect(Collectors.toList());
        return employeeDTOS;
    }

    public ResponseEntity<EmployeeDTO> getById(int id) {
        try {
            Optional<Employee> employee = employeeRepository.findById(id);
            if (employee.isPresent()) {

                EmployeeDTO employeeDTO = new EmployeeDTO(); //= employeeMapper.employeeToDTO(employee.get());
                mapper.map(employee.get(),employeeDTO);
                Optional<EmployeeDTO> emp = Optional.ofNullable(employeeDTO);
                return ResponseEntity.ok().body(emp.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    public ResponseEntity<String> saveNewEmployee(EmployeeDTO employeeDTO) {
        try {
            if (employeeDTO != null) {
                Employee employee = employeeMapper.empDTOToEmp(employeeDTO);
                employeeRepository.save(employee);
                return ResponseEntity.ok().body("Employee Created Successfully!");
            } else {
                return ResponseEntity.badRequest().body("Invalid Employee Data");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

   /* public ResponseEntity updateEmployee(EmployeeDTO employeeDTO) {
        try{
            Optional <Employee> employeeOptional = employeeRepository.findById(employeeDTO.getId());
            if (employeeOptional.isPresent()){


                Employee employee = employeeOptional.get();
                mapper.map(employeeDTO,employee);
                employeeRepository.save(employee);
                return ResponseEntity.ok().body("Employee updated successfully!");
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }*/



    public void updateEmployeeData(int id, Map<String, Object> emplyeeDTO) {
        Employee employeeToUpdate = employeeRepository
                .findById(id).orElseThrow();
        Class Employee = Employee.class;
        businessService.updateEntity(emplyeeDTO, employeeToUpdate, Employee);
        employeeRepository.saveAndFlush(employeeToUpdate);


    }

   /* public EmployeeDTO getByMapping(int id) {


        EmployeeDTO employee = mapper.map(employeeRepository.findById(id).get(), (Type) EmployeeDTO.class);
        return employee;
    }*/
}
