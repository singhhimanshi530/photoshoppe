package com.cg.productphotoshoppe.controller;

import java.util.List;
import java.util.Optional;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.productphotoshoppe.model.Customer;
import com.cg.productphotoshoppe.repository.CustomerRepository;
import com.cg.productphotoshoppe.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.cg.productphotoshoppe.exception.ResourceNotFoundException;
import com.cg.productphotoshoppe.exception.GlobalExceptionHandler;


//
@RestController
@RequestMapping("/api/v1")
@Api(value = "Customer Module",tags = "Customer Module")
public class CustomerController  {
	
@Autowired
private CustomerService customerService;
@Autowired
private CustomerRepository customerRepository;

@GetMapping("/customers")
public ResponseEntity<List<Customer>> getAllCustomers() throws ResourceNotFoundException  {
	
	List<Customer> customers= this.customerService.getAllCustomers();
		if(customers.isEmpty()) {
			throw new ResourceNotFoundException("No Customer added!");
		}
	
	return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
}




@PostMapping("/customers")
@ApiOperation(value = "Customer Registration",tags = "Customer Registration")
public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
	
	try {
		this.customerService.addCustomer(customer);
		//return ResponseEntity.ok().body(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
	}
	catch(Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}



@GetMapping("customers/{id}")
public ResponseEntity<Customer> findById(@PathVariable Integer id) throws ResourceNotFoundException {
	Customer cust=customerService.findById(id);
	if(cust==null) {
		throw new ResourceNotFoundException("Customer not found for this id: "+id);
	}
	//Customer cust=customerService.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer not found for this id:"+id));
return ResponseEntity.ok().body(cust);

}

@DeleteMapping("customers/{id}")
public ResponseEntity<Void> deleteCustomerById(@PathVariable ("id")Integer id) {
	try {
		
		this.customerService.deleteCustomerById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	} catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	//this.customerService.deleteCustomerById(id);
	
}

@PutMapping("/customers/{id}")
public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id,@RequestBody Customer customer) throws ResourceNotFoundException{
		customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));
		//cust.setCustomerId(customer.getCustomerId());
		Customer customer1=customerService.updateCustomer(id, customer);
		customer1.setAddress(customer.getAddress());
		customer1.setEmail(customer.getEmail());
		customer1.setFirstName(customer.getFirstName());
		customer1.setLastName(customer.getLastName());
		customer1.setPassword(customer.getPassword());
		customer1.setPhoneNo(customer.getPhoneNo());
		customer1.setUsername(customer.getUsername());
		return ResponseEntity.status(HttpStatus.OK).body(customer1);
	

	
}



	

}
