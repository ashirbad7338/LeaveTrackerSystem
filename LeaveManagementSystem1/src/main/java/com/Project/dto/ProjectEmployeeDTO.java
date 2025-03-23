package com.Project.dto;

import java.util.List;

import com.Project.entities.Employee;

public class ProjectEmployeeDTO {
	 private Long projectId;
	    private String projectName;
	    private List<Employee> employees;

	    // Getters and Setters
	    public Long getProjectId() {
	        return projectId;
	    }
	    
	    public void setProjectId(Long projectId) {
	        this.projectId = projectId;
	    }
	    public String getProjectName() {
	        return projectName;
	    }

	    public void setProjectName(String projectName) {
	        this.projectName = projectName;
	    }

	    public List<Employee> getEmployees() {
	        return employees;
	    }

	    public void setEmployees(List<Employee> employees) {
	        this.employees = employees;
	    }
}
