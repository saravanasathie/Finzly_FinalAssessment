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
	
	@GetMapping("gettransactionids/{id}")
	public Transaction getAllTransactionByIds(@PathVariable long id){
		return transactionService.getAllTransactionByIds(id);
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
	public Transaction addBill(@RequestBody Transaction transaction ) {
		return transactionService.addBill(transaction);
	}
	
	@GetMapping("getpending")
	public List<Transaction> getAllPendingBills(){
		return transactionService.getAllPendingBills();
	}
	@GetMapping("getsuccess")
	public List<Transaction> getAllSuccessBills(){
		return transactionService.getAllSuccessBills();
	}
	
	@PutMapping("pendingtosuccess/{id}")
	public String pendingtosuccess(@PathVariable long id) {
		return transactionService.pendingtosuccess(id);
	}
	@PutMapping("/payBill/{data}")
	public String payBill(@RequestBody Transaction data) {
		return transactionService.payBill(data);
	}
	
	@GetMapping("getAlltransactionByIdForSuccess/{id}")
	public List<Transaction> getAlltransactionByIdForSuccess(@PathVariable long id){
		return transactionService.getAlltransactionByIdForSuccess(id);
	}

	@GetMapping("getAlltransactionByIdForPending/{id}")
	public List<Transaction> getAlltransactionByIdForPending(@PathVariable long id){
		return transactionService.getAlltransactionByIdForPending(id);
	}
	
	@GetMapping("getTransactionData")
	public List<Transaction>getAllPaymentDetails(){
		return transactionService.getAllPaymentDetails();
		
	}
	
	
	
}
