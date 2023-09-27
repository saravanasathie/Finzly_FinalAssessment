package com.example.BBC.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BBC.dao.TransactionDao;
import com.example.BBC.entity.Customer;
import com.example.BBC.entity.Invoice;
import com.example.BBC.entity.Transaction;
import com.example.BBC.exception.ValidationException;

@Service
public class TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private InvoiceService invoiceService;

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

	public Transaction getAllTransactionByIds(long id) {
		List<Transaction> list = transactionDao.getAllTransaction();
		//List<Transaction> al = new ArrayList<>();
		for (Transaction book : list) {
			//Customer cId = book.getCustomer();
			if (book.gettId()== id && book.getStatus().toLowerCase().equals("pending")) {
				return book;
			}
		}
		return null;
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
					book.setTotalAmount((book.getRate() * book.getUnitConsumption())
							- (book.getRate() * book.getDiscount() * book.getUnitConsumption()));

					if ((date.before(book.getEndDate()) && date.after(book.getStartDate()))
							|| (date.equals(book.getEndDate()))) {
						book.setTotalAmount((book.getRate() * book.getUnitConsumption())
								- (book.getRate() * 0.05 * book.getUnitConsumption()));

					}

					return transactionDao.getAllTransactionUpdate(book);

				}
			}
			return "No Pending Transaction Found";
		}
	}

	public List<Transaction> getAllTransactionInvoice(long id, long tId) {
		List<Transaction> list = transactionDao.getAllTransaction();
		List<Transaction> al = new ArrayList<>();
		for (Transaction book : list) {
			Customer cId = book.getCustomer();
			if (cId.getCid() == id && book.gettId() == tId && book.getStatus().equals("pending")) {

				getAllTransactionUpdateAll(id, tId);
				al.add(book);
			}
		}
		return al;
	}

	public Transaction addBill(Transaction transaction) {
		Transaction addedBillData = transactionDao.addCustomerBill(transaction);

		Invoice invoiceinfo = new Invoice();
		invoiceinfo.setBillId(addedBillData.gettId());
		invoiceinfo.setRatePerKW(40.5);
		double amount = addedBillData.getUnitConsumption() * 41.5;
		double beforeDueDate = amount - ((amount * getDiscount("endDate")) / 100);
		invoiceinfo.setBeforeDueDateAmout(beforeDueDate);
		invoiceinfo.setAfterDueDateAmout(amount);

		invoiceService.addInvoiceInfo(invoiceinfo);
		return addedBillData;
	}

	public List<Transaction> getAllPendingBills() {
		List<Transaction> list = transactionDao.getAllBills();
		List<Transaction> newList = new ArrayList<>();
		for (Transaction tranction : list) {
			if (tranction.getStatus().equals("pending")) {
				newList.add(tranction);
			}
		}
		return newList;

	}

	public String pendingtosuccess(long id) {

		List<Transaction> list = transactionDao.getAllBills();
		for (Transaction customerBill : list) {
			long c = customerBill.gettId();
			if (c == id && customerBill.getStatus().equals("pending")) {
				customerBill.setStatus("success");
				return transactionDao.pendingtosuccess(customerBill);
			}

		}
		return "No one";

	}

	public String payBill(Transaction data) {
		List<Transaction> list = transactionDao.getAllPendingBill(data);
		for (Transaction customerBill : list) {
			if (customerBill.getStatus().equals("pending")) {
				customerBill.setStatus("success");
				return transactionDao.pendingtosuccess(customerBill);
			}

		}
		return "No one";

	}

	public double getDiscount(String transaction) {
		List<Transaction> dataList = transactionDao.getDiscount(transaction);
		if (!dataList.isEmpty()) {
	        return dataList.get(0).getDiscount();
	    } else {
	       return 0.0; 
	    }
	}

	public List<Transaction> getAlltransactionByIdForSuccess(long id) {
		try {
			List<Transaction> list = transactionDao.getAllTransaction();
			List<Transaction> newList = new ArrayList<>();
			for (Transaction tranction : list) {
				Customer customer = tranction.getCustomer();
				if (customer.getCid() == id && tranction.getStatus().equals("success")) {
					newList.add(tranction);
				}
			}

			if (newList.isEmpty()) {
				throw new ValidationException("No successful transactions found for customer " + id);
			}

			return newList;
		} catch (ValidationException e) {

			System.out.println("Error: " + e.getMessage());
			return null;
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
			return null;
		}
	}
	
	public List<Transaction> getAlltransactionByIdForPending(long id) {
		try {
			List<Transaction> list = transactionDao.getAllTransaction();
			List<Transaction> newList = new ArrayList<>();
			for (Transaction tranction : list) {
				Customer customer = tranction.getCustomer();
				if (customer.getCid() == id && tranction.getStatus().equals("pending")) {
					newList.add(tranction);
				}
			}

			if (newList.isEmpty()) {
				throw new ValidationException("No pending transactions found for customer " + id);
			}

			return newList;
		} catch (ValidationException e) {

			System.out.println("Error: " + e.getMessage());
			return null;
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
			return null;
		}
	}
	
	public List<Transaction> getAllPaymentDetails() {
		return transactionDao.getAllPaymentDetails();
	}

	public List<Transaction> getAllSuccessBills() {
		List<Transaction> list = transactionDao.getAllBills();
		List<Transaction> newList = new ArrayList<>();
		for (Transaction tranction : list) {
			if (tranction.getStatus().equals("success")) {
				newList.add(tranction);
			}
		}
		return newList;

	}


}
