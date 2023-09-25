package com.example.BBC.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BBC.dao.BillPaymentDetailsDao;
import com.example.BBC.dao.CustomerBillDataDao;
import com.example.BBC.entity.BillPaymentDetails;
import com.example.BBC.entity.CustomerBillData;

@Service
public class BillPaymentDetailsService {

	@Autowired
	private BillPaymentDetailsDao billPaymentDetailsDao;
	@Autowired
	private CustomerBillDataDao customerBillDataDao;

	public List<BillPaymentDetails> viewCashPayments() {
		return billPaymentDetailsDao.viewCashPayments();

	}

	public String addTransaction(BillPaymentDetails billPayment) {

		return billPaymentDetailsDao.addTransaction(billPayment);
	}

	public List<BillPaymentDetails> getTransactions(long customerId) {
		List<CustomerBillData> billDatas = customerBillDataDao.getCustomerBillDataById(customerId);
		List<BillPaymentDetails> successfulTransactions = new ArrayList<>();
		for (CustomerBillData customerBillData : billDatas) {
			if (customerBillData.getBillStatus().equals("paid")) {
				List<BillPaymentDetails> paymentDetails = billPaymentDetailsDao
						.getPaymentData(customerBillData.getBillId());
				if (paymentDetails.size() > 0) {
					successfulTransactions.add(paymentDetails.get(0));
				}

			}
		}
		return successfulTransactions;
	}

	public List<BillPaymentDetails> getAllPaymentDetails() {
		return billPaymentDetailsDao.getAllPaymentDetails();
	}
}