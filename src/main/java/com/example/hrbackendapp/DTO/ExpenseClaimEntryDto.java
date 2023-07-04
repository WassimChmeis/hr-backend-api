package com.example.hrbackendapp.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseClaimEntryDto {
    private Integer id;
    private LocalDate date;
    private Integer expenseType;
    private Integer expenseClaim;
    private String description;
    private Integer total;
}
