package com.example.hrbackendapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Table(name = "expense_claim_entry")
@Entity
@Data
public class ExpenseClaimEntry {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "expense_type", nullable = false, length = 50)
    private Integer expenseType;

    @Column(name = "expense_claim", nullable = false, length = 50)
    private Integer expenseClaim;

    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @Column(name = "total", nullable = false)
    private Integer total;


}