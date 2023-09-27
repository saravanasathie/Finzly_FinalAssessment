package com.example.BBC.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BBC.entity.Invoice;
import com.example.BBC.service.InvoiceService;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequestMapping("invoice")
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	
	@PostMapping("/addInvoiceInfo")
	public void addInvoiceInfo(@RequestBody Invoice invoiceinfo ) {
		invoiceService.addInvoiceInfo(invoiceinfo);
	}
	
	@GetMapping("/getInvoiceInfo/{billId}")
	public Invoice getInvoiceInfo(@PathVariable long billId) {
		return invoiceService.getInvoiceInfo(billId);
	}
	
	
	

}