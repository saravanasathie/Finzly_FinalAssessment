package com.example.BBC.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin()
@RestController
@RequestMapping("customer-data")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getAllCusomerData")
	public List<CustomerData> getAllCusomerBillData(){
		return customerService.getAllCusomerData();
	}
}