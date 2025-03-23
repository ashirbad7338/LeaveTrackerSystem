package com.Project.entities;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "Project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long project_Id;
	@Column(nullable = false)
	private String project_name;
	public Long getProject_Id() {
		return project_Id;
	}
	public void setProject_Id(Long project_Id) {
		this.project_Id = project_Id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
}
