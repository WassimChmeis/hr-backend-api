package com.example.hrbackendapp.service;


import com.example.hrbackendapp.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Service
public class BusinessService {

    public void updateEntity(Map<String, Object> emplyeeDTO, Employee employeeToUpdate, Class employee) {

        emplyeeDTO.forEach((k, v) -> {
            // use reflection to get field k on entityToUpdate and set it to value v
            Field field = ReflectionUtils.findField(employee, String.valueOf(k));
            field.setAccessible(true);
            ReflectionUtils.setField(field, employeeToUpdate, v);
        });

    }
}
