package com.Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.Project.entities.Employee;
import com.Project.entities.Login;
import com.Project.repositories.EmployeeRepository;
import com.Project.repositories.LoginRepository;
import com.Project.security.JwtUtil;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="http://localhost:5173")
public class LoginController {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	
//	@Autowired
//	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private JwtUtil jwt;
	
	@PostMapping("/login")
	public ResponseEntity<?> register(@RequestBody Login login){
		System.out.println("Login method");
		try {
			System.out.println("Login method 2");
			if (login == null || login.getLogin_Id() == null || login.getPassword() == null) {
                return new ResponseEntity<>("Login details are incomplete.", HttpStatus.BAD_REQUEST);
            }
			Employee emp=empRepo.findById(login.getLogin_Id()).orElse(null);
			if(emp==null) {
				return  new ResponseEntity<>("Employee not found!!!",HttpStatus.BAD_REQUEST);
			}
//			boolean match = encoder.matches(login.getPassword(), emp.getPassword());
//			String token="gonhnvfbib";
            if (login.getPassword().matches(emp.getPassword())) {
                String token = jwt.generateToken(emp.getEmp_Id(), emp.getRole());
//                System.out.println(token);
                return ResponseEntity.ok()
                        .body("{\"message\": \"Login successful\", \"token\":\""+token+"\", \"role\": \"" + emp.getRole() + "\"}");
            } else {
                return new ResponseEntity<>("Invalid password.", HttpStatus.BAD_REQUEST);
            }
		}catch(Exception e){
			
			return new ResponseEntity<>("An error occurred during login.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}

