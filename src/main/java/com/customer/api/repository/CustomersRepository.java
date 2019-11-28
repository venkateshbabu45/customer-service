package com.customer.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.api.domain.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, String>{
	public Customers findByFirstName(String firstName);
	public Customers findByeMail(String eMail);
}
