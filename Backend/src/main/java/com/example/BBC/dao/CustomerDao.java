package com.example.BBC.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BBC.entity.Customer;
import com.example.BBC.entity.CustomerBillData;



@Repository
public class CustomerDao {
	@Autowired
	private SessionFactory customerSessionFactory;

	public List<CustomerBillData> getAllCusomerData() {
		Session session = customerSessionFactory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		return criteria.list();
	}

}