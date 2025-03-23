package com.Project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.entities.Leave;

@Repository
public interface UserRequest extends JpaRepository<Leave, Long>{
	 List<Leave> findByStatus(Leave.LeaveStatus status);
	 List<Leave> findByEmpId(Long empId);
	 List<Leave> findByManagerId(Long managerId);
}
