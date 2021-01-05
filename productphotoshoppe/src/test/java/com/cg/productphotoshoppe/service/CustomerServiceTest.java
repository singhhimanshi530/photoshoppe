package com.cg.productphotoshoppe.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.productphotoshoppe.model.Customer;
import com.cg.productphotoshoppe.repository.CustomerRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
	@Autowired
	private CustomerService customerService;
	@MockBean
	private CustomerRepository customerRepository;

	@Test
				//testing for getAllCustomers
	public void testGetAllCustomers() {
		Customer customer1=new Customer();
		customer1.setFirstName("Himanshi");
		customer1.setLastName("Singh");
		customer1.setAddress("Kanpur");
		customer1.setEmail("singhhimanshi@gmail.com");
		customer1.setPassword("himanshi");
		customer1.setPhoneNo("987654321");
		customer1.setUsername("hsingh");
		
		
		Customer customer2=new Customer();
		customer2.setFirstName("Ankit");
		customer2.setLastName("Singh");
		customer2.setAddress("hyd");
		customer2.setEmail("singhankit@gmil.com");
		customer2.setPassword("ankit");
		customer2.setPhoneNo("9998887774");
		customer2.setUsername("aks");
		List<Customer> customerList=new ArrayList<>();
		customerList.add(customer1);
		customerList.add(customer2);
		Mockito.when(customerRepository.findAll()).thenReturn(customerList);
		assertThat(customerService.getAllCustomers()).isEqualTo(customerList);	
		}


	  @Test
    public void testFindById()
    {
     
		Optional<Customer> customer=Optional.of(new Customer(71, "himanshi", "singh", "Mumbai", "7798887774", "himanshi", "himanshisingh", "singhhimanshi@gmail.com"));
        when(customerRepository.findById(71)).thenReturn(customer);
        Customer cust=customerService.findById(71);
        assertEquals("himanshi", cust.getFirstName());
        assertEquals("singh", cust.getLastName());
        assertEquals("Mumbai", cust.getAddress());
        assertEquals("7798887774", cust.getPhoneNo());
        assertEquals("himanshi", cust.getPassword());
        assertEquals("himanshisingh", cust.getUsername());
        assertEquals("singhhimanshi@gmail.com", cust.getEmail());
    }
	 
	 @Test
	 public void testAddCustomer() {
		 Customer customers=new Customer(72, "Shalini", "Kumari", "Bangalore", "987654123", "shalini", "shalinikumari", "shalinikumari@gmail.com");
		Customer cust= customerRepository.save(customers);
		System.out.println(cust);
		Mockito.when(customerService.addCustomer(customers)).thenReturn(customers);
		//assertEquals(customerService.addCustomer(customers), customers);
	 }
	 @Test
	 public void testDeleteCustomerById() throws Exception {
	
		Customer customer1=new Customer();
		 customer1.setCustomerId(72);
			customer1.setFirstName("himanshi");
			customer1.setLastName("singh");
			customer1.setAddress("Mumbai");
			customer1.setEmail("singhhimanshi@gmail.com");
			customer1.setPassword("himanshi");
			customer1.setPhoneNo("7798887774");
			customer1.setUsername("himanshisingh");
			Customer customer2=new Customer();
			 customer2.setCustomerId(72);
				customer2.setFirstName("himanshi");
				customer2.setLastName("singh");
				customer2.setAddress("Mumbai");
				customer2.setEmail("singhhimanshi@gmail.com");
				customer2.setPassword("himanshiiii");
				customer2.setPhoneNo("7798886774");
				customer2.setUsername("himanshiiisingh");
			List<Customer> clist = new ArrayList<>();
			clist.add(customer1);
			Mockito.when(customerService.addCustomer(customer1)).thenReturn(customer1);
			Mockito.when(customerService.addCustomer(customer2)).thenReturn(customer2);
			Mockito.when(customerService.getAllCustomers()).thenReturn(clist);
			//Mockito.when(customerService.findById(customer1.getCustomerId())).thenReturn(customer1);
			customerService.deleteCustomerById(customer1.getCustomerId());
			System.out.println(clist.size());
			assertEquals(clist.size(), customerService.getAllCustomers().size());
			

	 }
	 @Test
	 public void testUpdateCustomer() {

		Customer customer1=new Customer();
		customer1.setCustomerId(1);
		customer1.setFirstName("himanshi");
		customer1.setLastName("singh");
		customer1.setAddress("Mumbai");
		customer1.setEmail("singhhimanshi@gmail.com");
		customer1.setPassword("himanshi");
		customer1.setPhoneNo("7798887774");
		customer1.setUsername("himanshisingh");
		Mockito.when(customerRepository.save(customer1)).thenReturn(customer1);
		customer1.setEmail("himanshi@yahoo.com");
		Mockito.when(customerService.updateCustomer(customer1.getCustomerId(), customer1)).thenReturn(customer1);
		assertEquals(customer1.getEmail(),"himanshi@yahoo.com");
		
	 }
}
