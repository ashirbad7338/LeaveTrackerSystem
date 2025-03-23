package com.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.entities.Employee;
import com.Project.repositories.EmployeeRepository;
import com.Project.repositories.ProjectRepository;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins="http://localhost:5173")
public class EmployeeController {

    @Autowired
    private EmployeeRepository empRepo;
    
    @Autowired
    private ProjectRepository projRepo;
    @GetMapping("/view")
    public List<Employee> getEmployee() {
        return empRepo.findAll();
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee e) {
    	Long projectid=e.getProject_Id();
    	if(projRepo.existsById(projectid)){
    		empRepo.save(e);
    		return new ResponseEntity<> (e, HttpStatus.CREATED);
    	}
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
    }
    
}
