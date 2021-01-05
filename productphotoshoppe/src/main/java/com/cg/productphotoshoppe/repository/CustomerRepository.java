package com.cg.productphotoshoppe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.productphotoshoppe.model.Customer;




@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
//@Query("select c from Customer c where  c.customerId=:customerId")
//List<Customer> findByCustomerId();

}
