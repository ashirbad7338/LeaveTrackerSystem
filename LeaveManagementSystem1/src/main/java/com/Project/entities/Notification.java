package com.Project.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Notification")
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long notif_Id;
	@Column(nullable = false)
	private Long emp_Id;
	@Column(nullable = false)
	private Long manager_Id;
	@Column(nullable = false)
	private String message;
	@Column(nullable = false)
	private NotifStatus status=NotifStatus.PENDING;
	public Long getNotif_Id() {
		return notif_Id;
	}
	public void setNotif_Id(Long notif_Id) {
		this.notif_Id = notif_Id;
	}
	public Long getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(Long emp_Id) {
		this.emp_Id = emp_Id;
	}
	public Long getManager_Id() {
		return manager_Id;
	}
	public void setManager_Id(Long manager_Id) {
		this.manager_Id = manager_Id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public NotifStatus getStatus() {
		return status;
	}
	public void setStatus(NotifStatus status) {
		this.status = status;
	}
	
}
