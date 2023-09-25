package com.example.BBC.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BBC.entity.Transaction;

@Repository
public class TransactionDao {
	@Autowired
	SessionFactory factory;
	
	public List<Transaction> getAllTransaction() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Transaction.class);
		return criteria.list();
	}

	public String getAllTransactionUpdate(Transaction book) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Transaction.class);
		session.update(book);
		session.beginTransaction().commit();
		return "Transaction Done";
	}
	
	public String addBill(Transaction transaction) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Transaction.class);
		session.save(transaction);
		session.beginTransaction().commit();
		return "Bill Details Added Successfully";
	}

	public String pendingtosuccess(Transaction t) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Transaction.class);
		session.update(t);
		session.beginTransaction().commit();
		return "Done";
		
	}

	public List<Transaction> getAllPendingBills() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Transaction.class);
		
		return criteria.list();
	}
}
