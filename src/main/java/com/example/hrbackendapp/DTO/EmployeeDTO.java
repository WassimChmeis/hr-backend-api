package com.example.hrbackendapp.DTO;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {


    private Integer id;
    private String name;
    private String email;
    private String address;
    private Integer departmentId;


}
