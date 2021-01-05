package com.cg.productphotoshoppe.service;

import java.util.List;
import java.util.Optional;

import com.cg.productphotoshoppe.exception.ResourceNotFoundException;
import com.cg.productphotoshoppe.model.Customer;


public interface CustomerService {
	//view all customers
public List<Customer> getAllCustomers();

	//create  new customer
public Customer addCustomer(Customer customer);

	//find customer by his id
public Customer findById(Integer id);

	//delete customer by his id
public void  deleteCustomerById(Integer id);

	//update customer by his id
public Customer updateCustomer(Integer id,Customer customer) ;


}
