package com.example.BBC.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BBC.entity.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public String addEmployee(Employee employee) {
		Session session=sessionFactory.openSession();
		session.save(employee);
		session.beginTransaction().commit();
		
		return "Employee data saved successfully";
	}

	public Employee checkEmployeeID(long employeeId) {
		Session session=sessionFactory.openSession();
		
		Employee employee=session.get(Employee.class, employeeId);
		return employee;
	}

}