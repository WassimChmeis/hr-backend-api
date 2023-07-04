package com.example.hrbackendapp.controller;

import com.example.hrbackendapp.DTO.*;
import com.example.hrbackendapp.model.ExpenseClaim;
import com.example.hrbackendapp.model.ExpenseClaimEntry;
import com.example.hrbackendapp.model.ExpenseType;
import com.example.hrbackendapp.service.ExpenseService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/expense/")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("")
    public ResponseEntity<ExpenseType> createExpenseType(@RequestBody ExpenseTypeDto expenseTypeDto){
        return expenseService.createExpenseType(expenseTypeDto);
    }

    @PostMapping("expense-claim")
    public ResponseEntity<ExpenseClaim> submitExpenseClaim(@RequestBody ExpenseClaimDto expenseClaim){
        return expenseService.submitExpenseClaim(expenseClaim);
    }

    @PostMapping("claim-entry")
    public ResponseEntity<String> submitExpenseClaimEntry(@RequestBody ExpenseClaimEntryDto entryDto){
        return expenseService.submitExpenseClaimEntry(entryDto);
    }

    @GetMapping("claims")
    public List<ClaimDto> getClaimsPerTypePerEmployee(@RequestParam("employeeId") int employeeId, @RequestParam("typeId") int typeId){
        return expenseService.getClaimsPerTypePerEmployee(employeeId,typeId);
    }

}
