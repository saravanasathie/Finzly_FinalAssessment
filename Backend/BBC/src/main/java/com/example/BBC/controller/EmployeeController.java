package com.example.BBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BBC.entity.Employee;
import com.example.BBC.service.EmployeeService;

@CrossOrigin(origins ="http://localhost:4200") 
@RestController
@RequestMapping("emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
//	@GetMapping("/employeeid/{id}")
//	public List<Employee> getEmployeeId(@PathVariable long id) {
//		return employeeService.getEmployeeId(id);
//	}
	
	@GetMapping("/employeeid/{id}")
	public Employee getEmployeeId(@PathVariable long id) {
		return employeeService.getEmployee(id);
	}
	
}

