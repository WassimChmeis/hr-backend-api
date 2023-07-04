package com.example.hrbackendapp.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseClaimDto {
    private Integer id;
    private LocalDate date;
    private String description;
    private Integer total;
    private String status;
    private Integer employeeId;
}
