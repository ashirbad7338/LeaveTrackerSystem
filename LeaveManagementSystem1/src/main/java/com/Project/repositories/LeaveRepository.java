package com.Project.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Project.entities.Leave;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long>{
	 // Find all leave requests for a specific employee
    List<Leave> findByEmpId(Long empId);

    // Find all approved leave requests for a specific employee
    List<Leave> findByEmpIdAndStatus(Long empId, Leave.LeaveStatus status);

}