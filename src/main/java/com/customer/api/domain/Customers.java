package com.customer.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="customers")
public class Customers implements Serializable{

	private static final long serialVersionUID = -1885342172208482879L;
	
	@Id
	private String customerId;
	
	private String firstName;
	private String lastName;
	private String middleName;
	private String phone;
	private String eMail;
	
	@JsonManagedReference("customer-address")
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
	private List<Address> addressList = new ArrayList<>();

	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customers(String customerId, String firstName, String lastName, String middleName, String phone,
			String eMail, List<Address> addressList) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.phone = phone;
		this.eMail = eMail;
		this.addressList = addressList;
	}



	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", phone=" + phone + ", eMail=" + eMail + ", addressList="
				+ addressList + "]";
	}

	
}
