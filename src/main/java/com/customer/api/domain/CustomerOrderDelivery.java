package com.customer.api.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="customer_order_delivery")
public class CustomerOrderDelivery implements Serializable{

	private static final long serialVersionUID = -77013733155448240L;

	@Id
	private int id;
	private String dateOfDelivery;
	private String deliveryStatus;
	
	
	@JsonBackReference("customer_orders-customer_order_delivery")
	@OneToOne
    @JoinColumn(name = "order_id")
	private CustomerOrders customerOrders;

	public CustomerOrderDelivery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerOrderDelivery(int id, String orderId, String dateOfDelivery, String deliveryStatus,
			CustomerOrders customerOrders) {
		super();
		this.id = id;
		this.dateOfDelivery = dateOfDelivery;
		this.deliveryStatus = deliveryStatus;
		this.customerOrders = customerOrders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateOfDelivery() {
		return dateOfDelivery;
	}

	public void setDateOfDelivery(String dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public CustomerOrders getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(CustomerOrders customerOrders) {
		this.customerOrders = customerOrders;
	}

	@Override
	public String toString() {
		return "CustomerOrderDelivery [id=" + id + ", dateOfDelivery=" + dateOfDelivery
				+ ", deliveryStatus=" + deliveryStatus + ", customerOrders=" + customerOrders + "]";
	}
	
	
}
