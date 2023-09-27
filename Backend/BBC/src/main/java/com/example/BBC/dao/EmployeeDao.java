package com.example.BBC.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BBC.entity.Customer;
import com.example.BBC.entity.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	SessionFactory factory;
	
	public List<Customer> getCustomerId(long id) {

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("cid", id));
		return criteria.list();
	}


	public List<Employee> getEmployeeId(long id) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("eId", id));
		return criteria.list();
	}
	
	public Employee getEmployee(long id) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("eId", id));
		return (Employee) criteria.uniqueResult();		
	}
}
