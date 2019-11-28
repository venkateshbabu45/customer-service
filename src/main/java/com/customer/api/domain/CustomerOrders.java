package com.customer.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="customer_orders")
public class CustomerOrders implements Serializable{

	private static final long serialVersionUID = -7722808382268613564L;

	@Id
	private String orderId;
	private String customerId;
	private String customerPaymentMethodId;
	private String dateOfOrder;
	private Double orderPrice;
	
	@JsonManagedReference("customer_orders-customer_order_products")
	@OneToMany(mappedBy="customerOrders", cascade = CascadeType.ALL)
	private List<CustomerOrderProducts> customerOrderProducts = new ArrayList<>();
	
	@JsonManagedReference("customer_orders-customer_order_delivery")
	@OneToOne(mappedBy="customerOrders", cascade = CascadeType.ALL)
	private CustomerOrderDelivery orderDelivery = new CustomerOrderDelivery();

	public CustomerOrders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerOrders(String orderId, String customerId, String customerPaymentMethodId, String dateOfOrder,
			Double orderPrice, List<CustomerOrderProducts> customerOrderProducts, CustomerOrderDelivery orderDelivery) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.customerPaymentMethodId = customerPaymentMethodId;
		this.dateOfOrder = dateOfOrder;
		this.orderPrice = orderPrice;
		this.customerOrderProducts = customerOrderProducts;
		this.orderDelivery = orderDelivery;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPaymentMethodId() {
		return customerPaymentMethodId;
	}

	public void setCustomerPaymentMethodId(String customerPaymentMethodId) {
		this.customerPaymentMethodId = customerPaymentMethodId;
	}

	public String getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(String dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public List<CustomerOrderProducts> getCustomerOrderProducts() {
		return customerOrderProducts;
	}

	public void setCustomerOrderProducts(List<CustomerOrderProducts> customerOrderProducts) {
		this.customerOrderProducts = customerOrderProducts;
	}

	public CustomerOrderDelivery getOrderDelivery() {
		return orderDelivery;
	}

	public void setOrderDelivery(CustomerOrderDelivery orderDelivery) {
		this.orderDelivery = orderDelivery;
	}

	@Override
	public String toString() {
		return "CustomerOrders [orderId=" + orderId + ", customerId=" + customerId + ", customerPaymentMethodId="
				+ customerPaymentMethodId + ", dateOfOrder=" + dateOfOrder + ", orderPrice=" + orderPrice
				+ ", customerOrderProducts=" + customerOrderProducts + ", orderDelivery=" + orderDelivery + "]";
	}
	
	
}
