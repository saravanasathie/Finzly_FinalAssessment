package com.example.BBC.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

	public List<Transaction> getAllBills() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Transaction.class);
		
		return criteria.list();
	}

	public List<Transaction> getAllPendingBill(Transaction data) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Transaction.class);
		criteria.add(Restrictions.eq("tId", data.getCustomer().getCid())); 
	    criteria.add(Restrictions.eq("status", "pending")); 
	    List<Transaction> pendingBills = criteria.list();
	    session.close();
	    return pendingBills;
	}

	public Transaction addCustomerBill(Transaction transaction) {
		Session session = factory.openSession();
		long id=(long) session.save(transaction);
		session.beginTransaction().commit();
		return session.get(Transaction.class,id);	
	}

	public List<Transaction> getDiscount(String transaction) {
		Session session= factory.openSession();
		Criteria criteria=session.createCriteria(Transaction.class);
		criteria.add(Restrictions.eq("transactionMethod", transaction));
		
		return criteria.list();
	}
	
	public List<Transaction> getAllPaymentDetails() {
		Session session = factory.openSession();
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Transaction> query = builder.createQuery(Transaction.class);
	    Root<Transaction> root = query.from(Transaction.class);

	    query.orderBy(builder.asc(root.get("tId"))); 

	    return session.createQuery(query).list();
	}

	
}
