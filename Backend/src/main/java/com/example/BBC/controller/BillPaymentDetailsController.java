package com.example.BBC.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.BBC.entity.BillPaymentDetails;
import com.example.BBC.service.BillPaymentDetailsService;


@RestController
@CrossOrigin()
public class BillPaymentDetailsController {
	
	@Autowired
	private BillPaymentDetailsService billPaymentService;
	
	@GetMapping("/viewCashPayments")
	public List<BillPaymentDetails> viewCashPayments() {
		return billPaymentService.viewCashPayments();
	}
	@GetMapping("getTransaction/{customerId}")
	public List<BillPaymentDetails> getTransactions(@PathVariable long customerId ) {
		return billPaymentService.getTransactions(customerId);
	}
	
	@GetMapping("getAllPaymentDetails")
	public List<BillPaymentDetails>getAllPaymentDetails(){
		return billPaymentService.getAllPaymentDetails();
		
	}
	
	
	
	
	
	
		
}