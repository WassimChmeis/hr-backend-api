package com.example.hrbackendapp.repository;

import com.example.hrbackendapp.model.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, Integer> {
}