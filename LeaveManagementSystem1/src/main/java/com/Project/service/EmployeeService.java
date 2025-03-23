package com.Project.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.entities.Employee;
import com.Project.entities.Leave;
import com.Project.entities.Project;
import com.Project.repositories.EmployeeRepository;
import com.Project.repositories.LeaveRepository;
import com.Project.repositories.ProjectRepository;

@Service
public class EmployeeService {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Map<String, Object> getEmployeeLeaveDetails(Long empId) {
        Map<String, Object> result = new HashMap<>();
        logger.info("Fetching details for Employee ID: {}", empId);

        // Get employee details
        Employee employee = employeeRepository.findById(empId).orElse(null);
        if (employee == null) {
            logger.error("Employee with ID {} not found.", empId);
            result.put("error", "Employee not found");
            return result;
        }

        logger.info("Employee Found: {}", employee.getEmp_Name());
        result.put("employeeName", employee.getEmp_Name());

        // Get project details (if assigned)
        Project project = (employee.getProject_Id() != null) 
                ? projectRepository.findById(employee.getProject_Id()).orElse(null) 
                : null;
        
        result.put("projectName", (project != null) ? project.getProject_name() : "No Project Assigned");

        // Fetch Leave Requests
        List<Leave> leaveRequests = leaveRepository.findByEmpId(empId);

        // Debugging: Log all leave requests
        for (Leave leave : leaveRequests) {
            logger.info("Leave ID: {}, Type: {}, Start: {}, End: {}", 
                leave.getLeaveId(), leave.getType(), leave.getStartDate(), leave.getEndDate());
        }

        // Calculate total leave days
        long totalLeaveDays = leaveRequests.stream()
                .mapToLong(leave -> ChronoUnit.DAYS.between(
                        convertToLocalDate(leave.getStartDate()), 
                        convertToLocalDate(leave.getEndDate())) + 1)
                .sum();

        // Count leave types
        long paidLeaveCount = leaveRequests.stream()
                .filter(leave -> leave.getType() == Leave.LeaveType.PAID)
                .mapToLong(leave -> ChronoUnit.DAYS.between(
                        convertToLocalDate(leave.getStartDate()), 
                        convertToLocalDate(leave.getEndDate())) + 1)
                .sum();

        long casualLeaveCount = leaveRequests.stream()
                .filter(leave -> leave.getType() == Leave.LeaveType.CASUAL)
                .mapToLong(leave -> ChronoUnit.DAYS.between(
                        convertToLocalDate(leave.getStartDate()), 
                        convertToLocalDate(leave.getEndDate())) + 1)
                .sum();

        logger.info("Total Leaves: {}", totalLeaveDays);
        logger.info("Paid Leaves: {}", paidLeaveCount);
        logger.info("Casual Leaves: {}", casualLeaveCount);

        result.put("totalLeaveDays", totalLeaveDays);
        result.put("paidLeaves", paidLeaveCount);
        result.put("casualLeaves", casualLeaveCount);

        return result;
    }

    private LocalDate convertToLocalDate(java.util.Date date) {
        if (date == null) {
            logger.warn("Encountered null date, returning default value.");
            return LocalDate.now(); // Handle null values gracefully
        }
        return new java.sql.Date(date.getTime()).toLocalDate();
    }

}
