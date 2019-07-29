package com.secondstep.skillmatrix.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	 private int employeeId;
	
	@Column(name="employee_no")
	 private int employeeNo;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "department_id")
	@Column(name="department")
	 private Department department;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "role_id")
	@Column(name="role")
	 private Role role;
	
	
	@Column(name="joining_date")
	 private Date joiningDate;
	
	@Column(name="experience_years_before")
	 private int experienceYearsBefore;
	
	@Column(name="is_active")
	 private char isActive;
	
	@OneToMany(mappedBy = "theEmployee",
			   cascade = {CascadeType.ALL})
	private List<EmployeeEvaluation> employeeEvaluations;
	public Employee() {
	}

	public Employee(int employeeNo, String employeeName, Department department, Role role, Date joiningDate,
			int experienceYearsBefore, char isActive) {
		this.employeeNo = employeeNo;
		this.employeeName = employeeName;
		this.department = department;
		this.role = role;
		this.joiningDate = joiningDate;
		this.experienceYearsBefore = experienceYearsBefore;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeNo=" + employeeNo + ", employeeName=" + employeeName
				+ ", department=" + department + ", role=" + role + ", joiningDate=" + joiningDate
				+ ", experienceYearsBefore=" + experienceYearsBefore + ", isActive=" + isActive + "]";
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public int getExperienceYearsBefore() {
		return experienceYearsBefore;
	}

	public void setExperienceYearsBefore(int experienceYearsBefore) {
		this.experienceYearsBefore = experienceYearsBefore;
	}

	public char getIsActive() {
		return isActive;
	}

	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}
	
	public List<EmployeeEvaluation> getEmployeeEvaluations() {
		return employeeEvaluations;
	}

	public void setEmployeeEvaluations(List<EmployeeEvaluation> employeeEvaluations) {
		this.employeeEvaluations = employeeEvaluations;
	}

	public void addEvaluation(EmployeeEvaluation theEmployeeEvaluations)
	{
	if(employeeEvaluations==null)
	{
		employeeEvaluations=new ArrayList<>();
	}
	employeeEvaluations.add(theEmployeeEvaluations);
	theEmployeeEvaluations.setTheEmployee(this);
	}
}
