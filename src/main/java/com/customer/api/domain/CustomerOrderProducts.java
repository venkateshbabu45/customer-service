package com.customer.api.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="customer_order_products")
public class CustomerOrderProducts implements Serializable{

	private static final long serialVersionUID = 8510324961867885137L;

	@Id
	private int id;
	private String productId;
	private int quantity;
	
	@JsonBackReference("customer_orders-customer_order_products")
	@ManyToOne
	@JoinColumn(name="order_id")
	private CustomerOrders customerOrders;

	public CustomerOrderProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerOrderProducts(int id, String orderId, String productId, int quantity,
			CustomerOrders customerOrders) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.customerOrders = customerOrders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CustomerOrders getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(CustomerOrders customerOrders) {
		this.customerOrders = customerOrders;
	}

	@Override
	public String toString() {
		return "CustomerOrderProducts [id=" + id + ", productId=" + productId + ", quantity="
				+ quantity + ", customerOrders=" + customerOrders + "]";
	}
	
	
}
