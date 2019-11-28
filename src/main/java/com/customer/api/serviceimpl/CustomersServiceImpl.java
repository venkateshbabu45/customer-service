package com.customer.api.serviceimpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.customer.api.domain.Address;
import com.customer.api.domain.Customers;
import com.customer.api.repository.CustomersRepository;
import com.customer.api.service.CustomersService;

@Service
public class CustomersServiceImpl implements CustomersService{

	@Autowired
	private CustomersRepository customerRepository;
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	Session mailSession;
	
	String line = "";
	
	@Override
	public void createCustomer(Customers customer) {
		customerRepository.save(customer);
	}

	@Override
	public Customers findCustomerById(String customerId) {
		Optional<Customers> customerDBObject = null;
		if(customerId!=null && !customerId.isEmpty()) {
			customerDBObject = customerRepository.findById(customerId);
		}
		Customers customer = new Customers();
		if(customerDBObject != null) {
			customer = customerDBObject.get();
		}
		return customer;
	}

	@Override
	public List<Customers> findAllCustomers() {
		List<Customers> customerList = new ArrayList<>();
		customerList = customerRepository.findAll();
		return customerList;
	}

	@Override
	public Customers findCustomerByFirstName(String firstName) {
		Customers customer = new Customers();
		customer = customerRepository.findByFirstName(firstName);
		return customer;
	}

	@Override
	public Customers findCustomerByEMail(String eMail) {
		System.out.println("+++++++++++"+eMail);
		Customers customer = new Customers();
		customer = customerRepository.findByeMail(eMail);
		//customer = customerRepository.findByLastName(eMail);
		return customer;
	}
	
	 public String sendEmail(String email) {
	        MimeMessage message = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);

	        try {
	            helper.setTo(email);
	            helper.setText("Greetings :)");
	            helper.setSubject("Mail From Spring Boot");
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            return "Error while sending mail ..";
	        }
	        javaMailSender.send(message);
	        return "Mail Sent Success!";
	    }
	 
	 public String saveCustomerData() {
	        try {
			/*
			 * List<List<String>> records = new ArrayList<>(); String row = "";
			 * BufferedReader csvReader = new BufferedReader(new
			 * FileReader("src/main/resources/customer.csv")); while ((row =
			 * csvReader.readLine()) != null) { String[] data = row.split(","); // do
			 * something with the data } csvReader.close();
			 */	        	
	            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/customer.csv"));
	            while((line = br.readLine()) != null) {
	            	System.out.println(br.readLine()+"&&&&&&&&&&&&&"+line);
	            	String[] data = line.split(",");
	            	System.out.println(data+"+++++++++++++");
	            	
	            	
	           /* 	Address address = new Address();
	            	address.setAddressId(data[6]);
	            	address.setLine1(data[7]);
	            	address.setLine2(data[8]);
	            	address.setCity(data[9]);
	            	address.setState(data[10]);
	            	address.setZipcode(data[11]);
	            	
	            	List<Address> addressList = new ArrayList<>();
	            	addressList.set(0, address);
	            	
	            	Customers customers =new Customers();
	            	customers.setCustomerId(data[0]);
	            	customers.setFirstName(data[1]);
	            	customers.setLastName(data[2]);
	            	customers.setMiddleName(data[3]);
	            	customers.setPhone(data[4]);
	            	customers.seteMail(data[5]);
	            	customers.setAddressList(addressList);
	            	address.setCustomer(customers); 
	            	customers.save(customers);
	            	*/
	            }
	            return "Customer Created Successfully!";
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "Error while reading ..";
	        }
	    }
	 
}
