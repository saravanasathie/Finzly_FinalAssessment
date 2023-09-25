package com.example.BBC.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BBC.entity.BillPaymentDetails;


@Repository
public class BillPaymentDetailsDao {
	@Autowired
	private SessionFactory billPaymentSessionFactory;

	public String addTransaction(BillPaymentDetails billPayment) {

		Session session = billPaymentSessionFactory.openSession();

		session.save(billPayment);
		session.beginTransaction().commit();
		return "Payment done successfully";
	}

	public List<BillPaymentDetails> viewCashPayments() {
		
		Session session = billPaymentSessionFactory.openSession();
		Criteria criteria=session.createCriteria(BillPaymentDetails.class);
		criteria.add(Restrictions.eq("paymentType","cash"));
		
		return criteria.list();
	}
	public List<BillPaymentDetails> getPaymentData(int billid){
		Session session = billPaymentSessionFactory.openSession();
		Criteria criteria=session.createCriteria(BillPaymentDetails.class);
		criteria.add(Restrictions.eq("billId",billid));
		return criteria.list();
	}

	public List<BillPaymentDetails> getAllPaymentDetails() {
		Session session = billPaymentSessionFactory.openSession();
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<BillPaymentDetails> query = builder.createQuery(BillPaymentDetails.class);
	    Root<BillPaymentDetails> root = query.from(BillPaymentDetails.class);

	    query.orderBy(builder.asc(root.get("billId"))); // Sort by billId in ascending order

	    return session.createQuery(query).list();
	}

}