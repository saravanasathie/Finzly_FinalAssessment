package com.example.BBC.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.BBC.entity.CustomerBillData;


@CrossOrigin()
@RestController
@RequestMapping("Bill-Payment")
public class CustomerBillDataController {
	@Autowired
	private CustomerBillDataService customerBillDataService;


	@PostMapping("/addCustomerBill")
	public CustomerBillData addCustomerBill(@RequestBody CustomerBillData customerBillData) {
		return customerBillDataService.addCustomerBill(customerBillData);
	}

	@PostMapping("/uploadBulk")
	public Object uploadCustomerBillData(@RequestParam("csvFile") MultipartFile file){
		try {
			return customerBillDataService.uploadCustomerBillData(file);
		}
		catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@GetMapping("/paidBills")
	public List<CustomerBillData> getPaidBills() {
		return customerBillDataService.getPaidBills();
	}
	
	@GetMapping("/unpaidBills")
	public List<CustomerBillData> getUnpaidBills() {
		return customerBillDataService.getUnpaidBills();
	}
	
	@GetMapping("/getByCustomer-id/{customerId}")
	public List<CustomerBillData> getCustomerBillDataById(@PathVariable long customerId){
		return customerBillDataService.getCustomerBillDataById(customerId);
	}
	
	@GetMapping("/getAllCusomerBillData")
	public List<CustomerBillData> getAllCusomerBillData(){
		return customerBillDataService.getAllCusomerBillData();
	}
	
	@PutMapping("/payBill")
	public String payBill(@RequestBody CustomerBillData customerBillData) {
		return customerBillDataService.payBill(customerBillData);
	}
	@PutMapping("/payBillOnline")
	public String payBillOnline(@RequestBody CustomerBillData customerBillData) {
		return customerBillDataService.payBillOnline(customerBillData);
	}
	
	
	@GetMapping("/searchByName/{customerName}")
	public List<CustomerBillData> getDataByName(@PathVariable String customerName) {
		return customerBillDataService.getDataByName(customerName);
	}
	@GetMapping("getById/{billid}")
	public CustomerBillData getSpecificBill(@PathVariable int billid) {
		return customerBillDataService.getSpecificBill(billid);
	}
	
	
	
	

}