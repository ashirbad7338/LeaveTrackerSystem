package com.Project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Login")
public class Login {
	
	@Id
	@Column(nullable=false)
	private Long login_Id;
	
	@OneToOne
	private Employee employee;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private Role role;

	public Long getLogin_Id() {
		return login_Id;
	}

	public void setLogin_Id(Long login_Id) {
		this.login_Id = login_Id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
