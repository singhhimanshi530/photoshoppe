package com.cg.productphotoshoppe.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.productphotoshoppe.exception.ResourceNotFoundException;
import com.cg.productphotoshoppe.model.Customer;


import com.cg.productphotoshoppe.repository.CustomerRepository;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
@Autowired
private CustomerRepository customerRepository;

@Override
public List<Customer> getAllCustomers() {
	return this.customerRepository.findAll();
}

@Override
public Customer addCustomer(Customer customer) {
	
	return this.customerRepository.save(customer);
}

@Override
public void deleteCustomerById(Integer id) {
	  this.customerRepository.deleteById(id);
	
}

@Override
public Customer updateCustomer(Integer id,Customer customer){

customer.setCustomerId(id);
return customerRepository.save(customer);

	
}

@Override
public Customer findById(Integer id) {
	Customer customer=null;
	Optional<Customer> cust=this.customerRepository.findById(id);
	if(cust.isPresent()) {
		customer=cust.get();
	}
	return customer;
}





}
