package com.example.hrbackendapp.repository;

import com.example.hrbackendapp.model.Leave;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {

    @Query(value = "SELECT * FROM `Leave` WHERE employee_id = ? AND `from` >= ? AND `to` <= ?", nativeQuery = true)
    List<Leave> findByEmployeeIdAndDateRange(@Param("employeeId") Integer employeeId,
                                             @Param("startDate") LocalDate startDate,
                                             @Param("endDate") LocalDate endDate);

    Page<Leave> findByLeaveTypeAndEmployeeId(Integer leaveType, Integer employeeId, Pageable pageable);

}