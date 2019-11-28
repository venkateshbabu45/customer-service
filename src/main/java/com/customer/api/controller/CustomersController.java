package com.customer.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.api.client.CustomerServiceClient;
import com.customer.api.domain.CustomerOrders;
import com.customer.api.domain.Customers;
import com.customer.api.service.CustomersService;

@RestController
@RequestMapping("/customer")
public class CustomersController {
	@Autowired
	private CustomersService customerService;
	
	@Autowired
	private CustomerServiceClient customerServiceClient;
	
	/*@PostMapping("/create")
	public void createCustomer(@RequestBody Customers customer){
		System.out.println(customer.geteMail()+"================");
		customerService.createCustomer(customer);
	}*/
	@PostMapping("/create")
	public String createCustomer(@RequestBody Customers customer){
		String message = null;
		if(customerService.findCustomerByEMail(customer.geteMail()) != null) {
			message = "Email is already exist";
		}else {
			customerService.createCustomer(customer);
			customerService.sendEmail(customer.geteMail());
			message = "Customer created Successfully";
		}
		return message;
	}
	
	@RequestMapping(path="/import")
	public String importCustomer(){
		return customerService.saveCustomerData();
	}
	
	@GetMapping("/findByEMail/{eMail}")
	public Customers findCustomerByEMail(@PathVariable String eMail) {
		return customerService.findCustomerByEMail(eMail);
	}
	@GetMapping("/findById/{customerId}")
	public Customers findCustomerById(@PathVariable String customerId) {
		return customerService.findCustomerById(customerId);
	}
	
	@GetMapping("/findByFirstName/{firstName}")
	public Customers findCustomerByFirstName(@PathVariable String firstName) {
		return customerService.findCustomerByFirstName(firstName);
	}
	@GetMapping("/findAll")
	public List<Customers> findAllCustomers(){
		List<Customers> customerList = customerService.findAllCustomers();
		return customerList;
	}
	
	@GetMapping("/findCustomerOrders/{customerId}")
	public Customers findCustomerOrdersByCustomerId(@PathVariable String customerId){
		Customers customer = customerService.findCustomerById(customerId);
		List<CustomerOrders> customerList = customerServiceClient.getCustomerProducts(customerId);
		return customer;
	}
	
}