package com.Project.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.dto.EmployeeDTO;
import com.Project.dto.ProjectEmployeeDTO;
import com.Project.entities.Employee;
import com.Project.entities.Project;
import com.Project.repositories.EmployeeRepository;
import com.Project.repositories.ProjectRepository;
import com.Project.service.ProjectService;
//import com.Project.service.ProjectService;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins="http://localhost:5173")
public class ProjectController {
	

	@Autowired
    private ProjectService employeeService;
	@Autowired
	private ProjectRepository projectRepo;
    @GetMapping("/show/{projectId}")
    public List<Employee> viewEmployeeProject(@PathVariable Long projectId) {
        return employeeService.getEmployeesProjectId(projectId);
    }
    @PostMapping("/add")
    public Project addProject(@RequestBody Project p) {
        return projectRepo.save(p); 
    }
    
    @GetMapping("/showall")
    public List<Project> viewProjects(){
    	return projectRepo.findAll();
    }

    // GET endpoint to fetch all projects with employees
//    @GetMapping("/employees")
//    public List<ProjectEmployeeDTO> getAllProjectsWithEmployees() {
//        return projectService.getProjectsWithEmployees(); // This will return the list of projects with employees
//    }
	
	
	
	
}