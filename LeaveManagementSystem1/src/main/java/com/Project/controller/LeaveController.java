package com.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.entities.Leave;
import com.Project.service.LeaveService;

@RestController
@RequestMapping("/api/leave-requests")
@CrossOrigin("http://localhost:5173")
public class LeaveController {
	@Autowired
    private LeaveService leaveRequestService;
    // Endpoint to create a leave request
    @PostMapping
    public Leave createLeaveRequest(@RequestBody Leave leaveRequest) {
        return leaveRequestService.createLeaveRequest(leaveRequest);
    }

    // Endpoint to approve a leave request
    @PutMapping("/{leaveId}/approve")
    public Leave approveLeave(@PathVariable Long leaveId) {
        return leaveRequestService.approveLeave(leaveId);
    }

    // Endpoint to reject a leave request
    @PutMapping("/{leaveId}/reject")
    public Leave rejectLeave(@PathVariable Long leaveId) {
        return leaveRequestService.rejectLeave(leaveId);
    }

    // Endpoint to delete a leave request (for a specific leaveId)
    @DeleteMapping("/{leaveId}")
    public void deleteLeaveRequest(@PathVariable Long leaveId) {
        leaveRequestService.deleteLeaveRequest(leaveId);
    }

    // Endpoint to get all leave requests for a specific employee
    @GetMapping("/employee/{empId}")
    public List<Leave> getAllLeavesForEmployee(@PathVariable Long empId) {
        return leaveRequestService.getAllLeavesForEmployee(empId);
    }
    
 // Endpoint to get all leave requests for all employees
    @GetMapping("/allleaves")
    public List<Leave> getAllLeaveRequests() {
        return leaveRequestService.getAllLeaveRequests();
    }
}
