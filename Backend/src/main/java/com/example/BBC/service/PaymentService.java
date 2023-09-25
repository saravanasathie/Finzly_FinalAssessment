package com.example.BBC.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {
	@Autowired
	PaymentDao paymentDao;

	public String addPaymentType(PaymentType paymentType) {
		return paymentDao.addPaymentType(paymentType);
	}

	public double getDiscount(String paymentMode) {
		List<Payment> dataList= paymentTypeDao.getDiscount(paymentMode);
		return dataList.get(0).getDiscount();
		
	}

}