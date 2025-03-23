package com.Project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.entities.Leave;
import com.Project.repositories.LeaveRepository;

@Service
public class LeaveService {
	 @Autowired
	 private LeaveRepository leaveRequestRepository;

	    // Create a new leave request
	    public Leave createLeaveRequest(Leave leaveRequest) {
	        // Check if the employee already has 5 approved leaves of the same type
	        long maxApprovedLeaves = 5;

	        // Get all approved leaves of the same type for the given employee
	        List<Leave> approvedLeaves = leaveRequestRepository.findByEmpIdAndStatus(
	            leaveRequest.getEmpId(), Leave.LeaveStatus.APPROVED
	        );

	        long count = approvedLeaves.stream()
	            .filter(leave -> leave.getType() == leaveRequest.getType())  // Filter by leave type
	            .count();

	        if (count >= maxApprovedLeaves) {
	            throw new IllegalStateException("Cannot request more than 5 leaves of type " 
	                + leaveRequest.getType() + " for this employee.");
	        }

	        return leaveRequestRepository.save(leaveRequest);
	    }

	    // Approve a leave request
	    public Leave approveLeave(Long leaveId) {
	        Optional<Leave> leaveRequestOptional = leaveRequestRepository.findById(leaveId);
	        if (leaveRequestOptional.isPresent()) {
	            Leave leaveRequest = leaveRequestOptional.get();
	            leaveRequest.setStatus(Leave.LeaveStatus.APPROVED);
	            return leaveRequestRepository.save(leaveRequest);
	        }
	        return null;
	    }

	    // Reject a leave request
	    public Leave rejectLeave(Long leaveId) {
	        Optional<Leave> leaveRequestOptional = leaveRequestRepository.findById(leaveId);
	        if (leaveRequestOptional.isPresent()) {
	            Leave leaveRequest = leaveRequestOptional.get();
	            leaveRequest.setStatus(Leave.LeaveStatus.REJECTED);
	            return leaveRequestRepository.save(leaveRequest);
	        }
	        return null;
	    }
	    
	 // Method to get all leave requests for all employees
	    public List<Leave> getAllLeaveRequests() {
	        return leaveRequestRepository.findAll();
	    }

	    // Delete a leave request
	    public void deleteLeaveRequest(Long leaveId) {
	        leaveRequestRepository.deleteById(leaveId);
	    }

	    // Get all leave requests for a specific employee
	    public List<Leave> getAllLeavesForEmployee(Long empId) {
	        return leaveRequestRepository.findByEmpId(empId);
	    }

}
