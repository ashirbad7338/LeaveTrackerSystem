package com.Project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeLeaveController {
	@Autowired
    private EmployeeService employeeService;

    @GetMapping("/leave-details/{empId}")
    public ResponseEntity<Map<String, Object>> getEmployeeLeaveDetails(@PathVariable Long empId) {
        Map<String, Object> leaveDetails = employeeService.getEmployeeLeaveDetails(empId);

        if (leaveDetails.containsKey("error")) {
            return new ResponseEntity<>(leaveDetails, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(leaveDetails, HttpStatus.OK);
    }
}
