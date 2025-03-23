package com.Project.entities;

import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

//import jakarta.persistence.*;
@Entity
@Table(name="Employee")
public class Employee {
	@Id
	private Long emp_Id;
	@Column(name="emp_Name")
	private String emp_Name;
	@Column(name="project_Id")
	private Long project_Id;
	@Column(name="mobile")
	private String mobile;
	@Column(name="mail_Id")
	private String mail_Id;
	@Column(name="role")
	private Role role;
	@Column(name="password")
	private String password;
	public Long getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(Long emp_Id) {
		this.emp_Id = emp_Id;
	}
	public String getEmp_Name() {
		return emp_Name;
	}
	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}
	public Long getProject_Id() {
		return project_Id;
	}
	public void setProject_Id(Long project_Id) {
		this.project_Id = project_Id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMail_Id() {
		return mail_Id;
	}
	public void setMail_Id(String mail_Id) {
		this.mail_Id = mail_Id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
