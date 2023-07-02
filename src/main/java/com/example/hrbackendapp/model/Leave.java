package com.example.hrbackendapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "`leave`")
@Entity
@Setter @Getter
public class Leave {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "leave_type", nullable = false)
    private Integer leaveType;

    @Column(name = "`from`", nullable = false)
    private LocalDate from;

    @Column(name = "`to`", nullable = false)
    private LocalDate to;

    @Column(name = "number_of_days", nullable = false)
    private Integer numberOfDays;

    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    @Column(name = "note", nullable = false, length = 150)
    private String note;


}