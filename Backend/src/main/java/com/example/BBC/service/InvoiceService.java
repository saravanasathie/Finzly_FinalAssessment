package com.example.BBC.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BBC.dao.InvoiceDao;
import com.example.BBC.entity.Invoice;


@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceDao invoiceDao;
	
	public void addInvoiceInfo(Invoice invoiceinfo) {
		
		invoiceDao.addInvoiceInfo(invoiceinfo);
		
	}

	public Invoice getInvoiceInfo(int billId) {
		
		return invoiceDao.getInvoiceInfo(billId);
	}

}
