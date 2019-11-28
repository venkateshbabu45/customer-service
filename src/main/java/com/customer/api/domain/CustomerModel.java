package com.customer.api.domain;

import java.util.List;

public class CustomerModel {
	private Customers customers;
	private List<CustomerOrders> customerOrders;
	
	public CustomerModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CustomerModel(Customers customers, List<CustomerOrders> customerOrders) {
		super();
		this.customers = customers;
		this.customerOrders = customerOrders;
	}
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	public List<CustomerOrders> getCustomerOrders() {
		return customerOrders;
	}
	public void setCustomerOrders(List<CustomerOrders> customerOrders) {
		this.customerOrders = customerOrders;
	}
	
	
}
