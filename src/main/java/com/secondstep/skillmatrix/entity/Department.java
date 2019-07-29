package com.secondstep.skillmatrix.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="department_id")
	 private int departmentId;
	
	@Column(name="department_name")
	private String departmentName;
	
	@OneToMany(mappedBy = "department",
			   cascade = {CascadeType.DETACH,CascadeType.MERGE,
				          CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Employee> employees;
	
	public Department() {
	}
	public Department(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Employee> getEmployee() {
		return employees;
	}
	public void setEmployee(List<Employee> employees) {
		this.employees = employees;
	}
	public void addEmployee(Employee tempEmployee)
	{
	if(employees==null)
	{
		employees=new ArrayList<>();
	}
	employees.add(tempEmployee);
	tempEmployee.setDepartment(this);
	}
}
