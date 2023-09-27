package com.example.BBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.BBC.entity.Customer;
import com.example.BBC.service.CustomerService;

@CrossOrigin(origins ="http://localhost:4200") 
@RestController
@RequestMapping("cus")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customerid/{id}")
	public List<Customer> getCustomerId(@PathVariable long id) {
		return customerService.getCustomerId(id);
	}
	@GetMapping("getcus")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	} 
	
	
	@PostMapping("addcustomer")
	public String addCustomer(@RequestBody Customer customer ) {
		return customerService.addCustomer(customer);
	}
	
	
	@PostMapping("/upload")
	public String uploadCustomerData(@RequestParam("file") MultipartFile file) throws Exception {
		List<Customer> customerList = customerService.uploadCustomerData(file);

		return "Uploaded " + customerList.size() + " customer records.";
	}
	
	
}
