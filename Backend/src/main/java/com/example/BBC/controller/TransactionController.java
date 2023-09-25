package com.example.BBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BBC.entity.Customer;
import com.example.BBC.entity.Transaction;
import com.example.BBC.service.TransactionService;

@CrossOrigin(origins ="http://localhost:4200") 
@RestController
@RequestMapping("trans")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;

	@GetMapping("gettransaction")
	public List<Transaction> getAllTransaction(){
		return transactionService.getAllTransaction();
	}

	@GetMapping("gettransactionid/{id}")
	public List<Transaction> getAllTransactionById(@PathVariable long id){
		return transactionService.getAllTransactionById(id);
	}
	@GetMapping("getAlltransactionupdate/{id}/{tid}")
	public String getAllTransactionUpdate(@PathVariable long id,@PathVariable long tid){
		return transactionService.getAllTransactionUpdateAll(id,tid);
	}
	
	@GetMapping("getAllTransactionInvoice/{id}/{tId}")
	public List<Transaction> getAllTransactionInvoice(@PathVariable long id,@PathVariable long tId){
		return transactionService.getAllTransactionInvoice(id,tId);
	}
	
	@PostMapping("addbillforcustomer")
	public String addBill(@RequestBody Transaction transaction ) {
		return transactionService.addBill(transaction);
	}
	
	@GetMapping("addpending")
	public List<Transaction> getAllPendingBills(){
		return transactionService.getAllPendingBills();
	}
	
	@GetMapping("pendingtosuccess/{id}")
	public String pendingtosuccess(@PathVariable long id) {
		return transactionService.pendingtosuccess(id);
	}
	
}
