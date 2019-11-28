package com.customer.api.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="address")
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2638227075073772359L;
	@Id
	private String addressId;
	
	private String line1;
	private String line2;
	private String city;
	private String state;
	private String zipCode;
	
	@JsonBackReference("customer-address")
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customers customer;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String addressId, String line1, String line2, String city, String state, String zipCode,
			Customers customer) {
		super();
		this.addressId = addressId;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.customer = customer;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String data) {
		this.addressId = data;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipcode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", line1=" + line1 + ", line2=" + line2 + ", city=" + city
				+ ", state=" + state + ", zipCode=" + zipCode + ", customer=" + customer + "]";
	}
	
	
}
