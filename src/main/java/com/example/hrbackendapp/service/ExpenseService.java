package com.example.hrbackendapp.service;

import com.example.hrbackendapp.DTO.*;
import com.example.hrbackendapp.model.ExpenseClaim;
import com.example.hrbackendapp.model.ExpenseClaimEntry;
import com.example.hrbackendapp.model.ExpenseType;
import com.example.hrbackendapp.repository.ExpenseClaimEntryRepository;
import com.example.hrbackendapp.repository.ExpenseClaimRepository;
import com.example.hrbackendapp.repository.ExpenseTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseTypeRepository expenseTypeRepository;
    @Autowired
    private ExpenseClaimRepository expenseClaimRepository;
    @Autowired
    private ExpenseClaimEntryRepository entryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<ExpenseType> createExpenseType(ExpenseTypeDto expenseTypeDto) {
        ExpenseType expenseType = modelMapper.map(expenseTypeDto,ExpenseType.class);
        return ResponseEntity.ok(expenseTypeRepository.save(expenseType));
    }

    public ResponseEntity<ExpenseClaim> submitExpenseClaim(ExpenseClaimDto expenseClaimDto) {
        ExpenseClaim expenseClaim = modelMapper.map(expenseClaimDto,ExpenseClaim.class);
        return ResponseEntity.ok(expenseClaimRepository.save(expenseClaim));
    }

    public ResponseEntity<String> submitExpenseClaimEntry(ExpenseClaimEntryDto entryDto) {

        ExpenseClaimEntry expenseClaimEntry = modelMapper.map(entryDto,ExpenseClaimEntry.class);

        if (expenseClaimEntry!=null){

            int expenseClaimId = expenseClaimEntry.getExpenseClaim();
            int entryTotal = expenseClaimEntry.getTotal();
            int oldClaimTotal = expenseClaimRepository.findPrice(expenseClaimId);
            int updatedClaimTotal = entryTotal+oldClaimTotal;
            expenseClaimRepository.updateTotal(updatedClaimTotal,expenseClaimId);

            entryRepository.save(expenseClaimEntry);
            return ResponseEntity.ok().body(expenseClaimEntry+"\n"+"Expense Claim Total amount: "+updatedClaimTotal);
            //expenseClaimRepository.updateTotal(total,expClaimId);
        }
        return ResponseEntity.ok("");
    }




    public List<ClaimDto> getClaimsPerTypePerEmployee(int employeeId, int typeId) {

        //list of ClaimDto to be returned,
        //Each ClaimDto has ExpenseClaim plus List of entries related to it.
        List<ClaimDto> claimDtoList = new ArrayList<>();

        //get all ExpenseClaims by employee id
        List<ExpenseClaim> expenseClaims = expenseClaimRepository.findExpenseClaimsByEmployeeId(employeeId);

        //filtering entries by typeId
        for (int i=0;i<expenseClaims.size();i++){

            ClaimDto claimDto = new ClaimDto();

            //getting each ExpenseClaim from the List
            ExpenseClaim singleClaim = expenseClaims.get(i);
            claimDto.setExpenseClaim(singleClaim);

            //retrieving entries by type
            List<ExpenseClaimEntry> claimEntryList = entryRepository.findExpenseClaimEntriesByExpenseClaimAndExpenseType(singleClaim.getId(),typeId);

            claimDto.setEntries(claimEntryList);
            claimDtoList.add(claimDto);

        }
        return claimDtoList;
    }
}
