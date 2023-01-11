package com.nissan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblEmployeeRegistration")
public class EmployeeRegistration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer emp_id;
	
	private String firstName;
	
	private String lastName;

	public EmployeeRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeRegistration(Integer emp_id, String firstName, String lastName) {
		super();
		this.emp_id = emp_id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "EmployeeRegistration [emp_id=" + emp_id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

}
