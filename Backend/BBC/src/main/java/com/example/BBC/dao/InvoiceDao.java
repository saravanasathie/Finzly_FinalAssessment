package com.example.BBC.dao;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BBC.entity.Invoice;


@Repository
public class InvoiceDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addInvoiceInfo(Invoice invoiceinfo) {
		Session session=sessionFactory.openSession();
		session.save(invoiceinfo);
		session.beginTransaction().commit();
		
	}

	public Invoice getInvoiceInfo(long billId) {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Invoice.class);
		criteria.add(Restrictions.eq("billId",billId));
		return (Invoice) criteria.list().get(0);	
	}
	
}