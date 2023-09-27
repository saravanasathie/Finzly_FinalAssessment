package com.example.BBC.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BBC.dao.EmployeeDao;
import com.example.BBC.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	public List<Employee> getEmployeeId(long id) {
		List<Employee> employees = employeeDao.getEmployeeId(id);
		List<Employee> al = new ArrayList<>();
		for (Employee employee : employees) {
			if(employee.geteId() == id) {
				al.add(employee);
				return al;
			}
		}
		return null;
	}
	
	public Employee getEmployee(long id) {
		Employee employee = employeeDao.getEmployee(id);
		if(employee==null) {
			return null;
		}
		return employee;
	}
}
