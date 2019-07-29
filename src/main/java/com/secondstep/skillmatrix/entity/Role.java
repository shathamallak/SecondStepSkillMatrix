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
@Table(name="role")
public class Role {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="role_id")
 private int roleId;

@Column(name="role_name")
private String roleName;

@OneToMany(mappedBy = "role",
cascade = {CascadeType.DETACH,CascadeType.MERGE,
	          CascadeType.PERSIST,CascadeType.REFRESH})
private List<Employee> employees;
	
public Role() {
}

public Role(String roleName) {
	this.roleName = roleName;
}



	@Override
public String toString() {
	return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
}


	public int getRoleId() {
	return roleId;
}


public void setRoleId(int roleId) {
	this.roleId = roleId;
}


public String getRoleName() {
	return roleName;
}


public void setRoleName(String roleName) {
	this.roleName = roleName;
}


	public List<Employee> getEmployees() {
	return employees;
}


public void setEmployees(List<Employee> employees) {
	this.employees = employees;
}
public void addEmployee(Employee tempEmployee)
{
if(employees==null)
{
	employees=new ArrayList<>();
}
employees.add(tempEmployee);
tempEmployee.setRole(this);
}

	

}
