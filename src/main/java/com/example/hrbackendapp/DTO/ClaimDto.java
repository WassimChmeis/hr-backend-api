package com.example.hrbackendapp.DTO;

import com.example.hrbackendapp.model.ExpenseClaim;
import com.example.hrbackendapp.model.ExpenseClaimEntry;
import lombok.Data;

import java.util.List;
@Data
public class ClaimDto {
    private ExpenseClaim expenseClaim;
    private List<ExpenseClaimEntry> entries;
}
