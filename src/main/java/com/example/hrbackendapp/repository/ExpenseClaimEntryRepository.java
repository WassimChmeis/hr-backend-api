package com.example.hrbackendapp.repository;

import com.example.hrbackendapp.model.ExpenseClaimEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseClaimEntryRepository extends JpaRepository<ExpenseClaimEntry, Integer> {

    List <ExpenseClaimEntry> findExpenseClaimEntriesByExpenseClaimAndExpenseType(@Param("expense_claim") int expenseClaim,@Param("expense_type") int expenseType  );

}