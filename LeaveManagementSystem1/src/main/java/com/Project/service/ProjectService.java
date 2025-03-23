package com.Project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.dto.EmployeeDTO;
import com.Project.dto.ProjectEmployeeDTO;
import com.Project.entities.Employee;
import com.Project.entities.Project;
import com.Project.repositories.EmployeeRepository;
import com.Project.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeesProjectId(Long projectId) {
        return employeeRepository.findByProjectId(projectId);
    }
}
