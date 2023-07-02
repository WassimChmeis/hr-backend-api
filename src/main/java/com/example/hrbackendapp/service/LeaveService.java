package com.example.hrbackendapp.service;


//import com.example.hrbackendapp.DTO.EmployeeLeavesDto;
import com.example.hrbackendapp.DTO.LeaveDto;
import com.example.hrbackendapp.model.Leave;
import com.example.hrbackendapp.model.LeaveType;
import com.example.hrbackendapp.repository.LeaveRepository;
import com.example.hrbackendapp.repository.LeaveTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LeaveService {

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;
    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private ModelMapper mapper;


    public LeaveType createNewLeaveType(LeaveType leaveType) {
        return leaveTypeRepository.save(leaveType);
    }

    public ResponseEntity<Leave> submitLeaveRequest(LeaveDto leaveDto) {

        Leave leave = mapper.map(leaveDto,Leave.class);

        return ResponseEntity.ok(leaveRepository.save(leave));
    }



    public List<Leave> getLeavesByEmployeeAndDateRange(int id, LocalDate startDate, LocalDate endDate) {
        return leaveRepository.findByEmployeeIdAndDateRange(id, startDate, endDate);
    }

    public Page<Leave> getLeavesByTypeAndEmployeeWithPagination(Integer leaveType, Integer employeeId, int page, int pageSize) {
        // Create a PageRequest for pagination
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        // Call the repository method to get leaves by type and employee with pagination
        return leaveRepository.findByLeaveTypeAndEmployeeId(leaveType, employeeId, pageRequest);
    }
}
