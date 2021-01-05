package com.cg.productphotoshoppe.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.productphotoshoppe.model.Customer;
import com.cg.productphotoshoppe.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	@Test
	public void testgetAllCustomers() {
		Customer customer1=new Customer();
		customer1.setAddress("kanpur");
		customer1.setEmail("singhimanshi@gmail.com");
		customer1.setFirstName("himanshi");
		customer1.setLastName("singh");
		customer1.setPassword("himanshi");
		customer1.setPhoneNo("987654321");
		customer1.setUsername("hsingh");
		
		Customer customer2=new Customer();
		customer2.setAddress("delhi");
		customer2.setEmail("shalini@gmail.com");
		customer2.setFirstName("shalini");
		customer2.setLastName("singh");
		customer2.setPassword("shalini");
		customer2.setPhoneNo("666854321");
		customer2.setUsername("ssingh");
		testEntityManager.persist(customer1);
		testEntityManager.persist(customer2);
		
		List<Customer> customerList=customerRepository.findAll();
		Assert.assertEquals(2, customerList.size());

	}
}
