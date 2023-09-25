package com.example.BBC.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BBC.dao.TransactionDao;
import com.example.BBC.entity.Customer;
import com.example.BBC.entity.Transaction;


@Service
public class TransactionService {

	@Autowired
	TransactionDao transactionDao;
	
	@Autowired
	SessionFactory factory;
	
	private Date date = new Date();
	
	public List<Transaction> getAllTransaction() {
		return transactionDao.getAllTransaction();
	}

	public List<Transaction> getAllTransactionById(long id) {
		List<Transaction> list = transactionDao.getAllTransaction();
		List<Transaction> al = new ArrayList<>();
		for (Transaction book : list) {
			Customer cId = book.getCustomer();
			if (cId.getCid() == id && book.getStatus().equals("success")) {

				al.add(book);
			}
		}
		return al;
	}

	public String getAllTransactionUpdateAll(long id, long tid) {
		if (id <= 0 || tid <= 0) {
			return "Wrong Input. Kindly Do check Again";
		} else {
			List<Transaction> list = transactionDao.getAllTransaction();
			List<Transaction> al = new ArrayList<>();
			for (Transaction book : list) {
				Customer cId = book.getCustomer();
				System.out.println(book.getRate());
				if (cId.getCid() == id && book.getStatus().equals("pending") && book.gettId() == tid) {

					book.setStatus("success");
					book.setTotalAmount((book.getRate()*book.getUnitConsumption())-(book.getRate() *book.getDiscount()* book.getUnitConsumption()));
					
					if ((date.before(book.getEndDate())
							&& date.after(book.getStartDate())) ||(date.equals(book.getEndDate()))){
						book.setTotalAmount((book.getRate()*book.getUnitConsumption())-(book.getRate() *0.05* book.getUnitConsumption()));
					
					}
					
					return transactionDao.getAllTransactionUpdate(book);
					
				}
			}
			return "No Pending Transaction Found";
		}
	}
	
	public List<Transaction> getAllTransactionInvoice(long id,long tId) {
		List<Transaction> list = transactionDao.getAllTransaction();
		List<Transaction> al = new ArrayList<>();
		for (Transaction book : list) {
			Customer cId = book.getCustomer();
			if (cId.getCid() == id && book.gettId()==tId &&book.getStatus().equals("pending")) {

				getAllTransactionUpdateAll(id, tId);
				al.add(book);
			}
		}
		return al;
	}
	
	public String addBill(Transaction transaction) {
		return transactionDao.addBill(transaction);
	}

	public List<Transaction> getAllPendingBills() {
		List<Transaction> list = transactionDao.getAllPendingBills();
		List<Transaction> newList = new ArrayList<>();
		for (Transaction tranction : list) {
			if (tranction.getStatus().equals("pending")) {
				newList.add(tranction);
			}
		}
		return newList;

	}

	public String pendingtosuccess(long id) {

		List<Transaction>list=	transactionDao.getAllPendingBills();
		for(Transaction customerBill : list) {
			long c = customerBill.gettId();
			if(c == id && customerBill.getStatus().equals("pending")) {
				customerBill.setStatus("success");
				return transactionDao.pendingtosuccess(customerBill);
			}
			
		}
		return "No one";


	}
	
	
}
