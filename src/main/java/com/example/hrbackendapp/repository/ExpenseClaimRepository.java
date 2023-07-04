package com.example.hrbackendapp.repository;

import com.example.hrbackendapp.model.ExpenseClaim;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseClaimRepository extends JpaRepository<ExpenseClaim, Integer> {

    @Query("select total from ExpenseClaim where id = :id")
    Integer findPrice(@Param("id")int id);

    @Modifying
    @Transactional
    @Query("UPDATE ExpenseClaim e SET e.total = :amount WHERE e.id = :id")
    void updateTotal(int amount,int id);

    List<ExpenseClaim> findExpenseClaimsByEmployeeId(int id);
}