package com.nissan.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblVisitTable")
public class SalesVisit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer visit_id;
	
	private String cust_name;
	
	private Integer contact_person;
	
	private Long contact_no;
	
	private String interest_product;
	
	private String visit_subject;
	
	private String description;
	
	private Date visit_datetime;
	
	private boolean is_disabled;
	
	private boolean is_deleted;
	
	private Integer emp_id;
	
	@ManyToOne
	@JoinColumn(name="emp_id", insertable=false, updatable=false)
	private EmployeeRegistration employee;

	public SalesVisit() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public SalesVisit(Integer visit_id, String cust_name) {
		super();
		this.visit_id = visit_id;
		this.cust_name = cust_name;
	}


	public SalesVisit(Integer visit_id, String cust_name, Integer contact_person, Long contact_no,
			String interest_product, String visit_subject, String description, Date visit_datetime, boolean is_disabled,
			boolean is_deleted, Integer emp_id, EmployeeRegistration employee) {
		super();
		this.visit_id = visit_id;
		this.cust_name = cust_name;
		this.contact_person = contact_person;
		this.contact_no = contact_no;
		this.interest_product = interest_product;
		this.visit_subject = visit_subject;
		this.description = description;
		this.visit_datetime = visit_datetime;
		this.is_disabled = is_disabled;
		this.is_deleted = is_deleted;
		this.emp_id = emp_id;
		this.employee = employee;
	}

	public Integer getVisit_id() {
		return visit_id;
	}

	public void setVisit_id(Integer visit_id) {
		this.visit_id = visit_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public Integer getContact_person() {
		return contact_person;
	}

	public void setContact_person(Integer contact_person) {
		this.contact_person = contact_person;
	}

	public Long getContact_no() {
		return contact_no;
	}

	public void setContact_no(Long contact_no) {
		this.contact_no = contact_no;
	}

	public String getInterest_product() {
		return interest_product;
	}

	public void setInterest_product(String interest_product) {
		this.interest_product = interest_product;
	}

	public String getVisit_subject() {
		return visit_subject;
	}

	public void setVisit_subject(String visit_subject) {
		this.visit_subject = visit_subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getVisit_datetime() {
		return visit_datetime;
	}

	public void setVisit_datetime(Date visit_datetime) {
		this.visit_datetime = visit_datetime;
	}

	public boolean isIs_disabled() {
		return is_disabled;
	}

	public void setIs_disabled(boolean is_disabled) {
		this.is_disabled = is_disabled;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public EmployeeRegistration getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeRegistration employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "VisitTable [visit_id=" + visit_id + ", cust_name=" + cust_name + ", contact_person=" + contact_person
				+ ", contact_no=" + contact_no + ", interest_product=" + interest_product + ", visit_subject="
				+ visit_subject + ", description=" + description + ", visit_datetime=" + visit_datetime
				+ ", is_disabled=" + is_disabled + ", is_deleted=" + is_deleted + ", emp_id=" + emp_id + ", employee="
				+ employee + "]";
	}
	
	

}
