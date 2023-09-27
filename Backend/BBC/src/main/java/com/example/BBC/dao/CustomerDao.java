package com.example.BBC.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BBC.entity.Customer;


@Repository
public class CustomerDao {

	@Autowired
	SessionFactory factory;

	
	public List<Customer> getCustomerId(long id) {

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("cid", id));
		return criteria.list();
	}

	public List<Customer> getAllCustomer() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		return criteria.list();
	}
	
	public String addCustomer(Customer customer) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		session.save(customer);
		session.beginTransaction().commit();
		return "Customer Details Added Successfully";
	}
}
