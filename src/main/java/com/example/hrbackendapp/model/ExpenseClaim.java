package com.example.hrbackendapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "expense_claim")
@Entity
@Setter
@Getter
public class ExpenseClaim {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "total", nullable = false)
    private Integer total;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;


}