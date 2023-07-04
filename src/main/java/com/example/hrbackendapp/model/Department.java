package com.example.hrbackendapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "department")
@Entity
@Setter@Getter
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;


}