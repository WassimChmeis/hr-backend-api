package com.example.hrbackendapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "expense_type")
@Entity
@Data
public class ExpenseType {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;


}