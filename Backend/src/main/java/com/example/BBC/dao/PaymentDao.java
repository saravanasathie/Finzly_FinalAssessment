package com.example.BBC.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BBC.entity.Payment;


@Repository
public class PaymentDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public String addPaymentType(Payment paymentType) {
		Session session=sessionFactory.openSession();
		session.save(paymentType);
		session.beginTransaction().commit();
		
		return "PaymentType data saved successfully";
		
		
	}

	public List<Payment> getDiscount(String paymentMode) {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Payment.class);
		criteria.add(Restrictions.eq("paymentMode", paymentMode));
		
		return criteria.list();
		
		
	}

}