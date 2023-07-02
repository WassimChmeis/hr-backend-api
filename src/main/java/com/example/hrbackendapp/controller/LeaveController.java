package com.example.hrbackendapp.controller;


import com.example.hrbackendapp.DTO.EmployeeLeavesDto;
import com.example.hrbackendapp.DTO.LeaveDto;
import com.example.hrbackendapp.model.Leave;
import com.example.hrbackendapp.model.LeaveType;
import com.example.hrbackendapp.repository.LeaveRepository;
import com.example.hrbackendapp.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/employee/leave/")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;
    @Autowired
    private LeaveRepository leaveRepository;

    @PostMapping("")
    public LeaveType createLeaveType(@RequestBody LeaveType leaveType){
        return leaveService.createNewLeaveType(leaveType);
    }

    @PostMapping("submit-leave")
    public ResponseEntity<Leave> submitLeaveRequest(@RequestBody LeaveDto leaveDto){
        return leaveService.submitLeaveRequest(leaveDto);
    }

    @GetMapping("")
    public List<Leave> getLeave(){
        return leaveRepository.findAll();
    }

    @GetMapping("{id}")
    public List<Leave> getEmployeeLeavesRange(
            @PathVariable int id,
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){

        return leaveService.getLeavesByEmployeeAndDateRange(id, startDate, endDate);

    }
    @GetMapping("get-leaves")
    public Page<Leave> getLeavesByTypeAndEmployeeWithPagination(
            @RequestParam(name = "type") Integer leaveType,
            @RequestParam(name = "employee") Integer employeeId,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int pageSize
    ){

        return leaveService.getLeavesByTypeAndEmployeeWithPagination(leaveType, employeeId, page, pageSize);
    }
}
