package com.customer.api.service;

import java.util.List;

import com.customer.api.domain.Customers;

public interface CustomersService {
	public void createCustomer(Customers customer);
	
	public Customers findCustomerById(String customerId);
	
	public Customers findCustomerByEMail(String eMail);
	
	public Customers findCustomerByFirstName(String firstName);
	
	public String sendEmail(String email); 
	
	public List<Customers> findAllCustomers();
	
	public String saveCustomerData() ;
}
