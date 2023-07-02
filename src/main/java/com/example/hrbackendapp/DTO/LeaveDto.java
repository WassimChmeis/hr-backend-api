package com.example.hrbackendapp.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
public class LeaveDto {

    private Integer id;
    private Integer leaveType;
    private LocalDate from;
    private LocalDate to;
    private Integer numberOfDays;
    private Integer employeeId;
    private String note;
}
