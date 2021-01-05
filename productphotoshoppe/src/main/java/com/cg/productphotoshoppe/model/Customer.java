package com.cg.productphotoshoppe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer1")

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_id")
	private Integer id;
	@Column(name="first_name",nullable = false)
	private String firstName;
	@Column(name="last_name",nullable = false)
	private String lastName;
	@Column(name="address",nullable = false)
	private String address;
	@Column(name="phone_no",nullable = false)
	private String phoneNo;
	@Column(name="password",nullable = false)
	private String password;
	@Column(name="username",nullable = false)
	private String username;
	@Column(name="email",nullable = false)
	private String email;
	public Integer getCustomerId() {
		return id;
	}
	public void setCustomerId(Integer customerId) {
		this.id = customerId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {//id=" + id + ",
		return "Customer [ id="+id+",firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", phoneNo=" + phoneNo + ", password=" + password + ", username=" + username
				+ ", email=" + email + "]";
	}
	public Customer(Integer id, String firstName, String lastName, String address, String phoneNo, String password,
			String username, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNo = phoneNo;
		this.password = password;
		this.username = username;
		this.email = email;
	}
	public Customer() {
		super();
		
	}
	
	
}
