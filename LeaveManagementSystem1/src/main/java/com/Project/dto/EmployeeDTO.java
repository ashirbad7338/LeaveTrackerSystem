package com.Project.dto;

public class EmployeeDTO {

    private Long empId;
    private String empName;
    private Long projectId;
    private String mobile;
    private String mailId;
    private String role;

    public EmployeeDTO(Long empId, String empName, Long projectId, String mobile, String mailId, String role) {
        this.empId = empId;
        this.empName = empName;
        this.projectId = projectId;
        this.mobile = mobile;
        this.mailId = mailId;
        this.role = role;
    }

    // Getters and Setters
    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
