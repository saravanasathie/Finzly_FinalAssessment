package com.example.BBC.service;

package com.finzly.UtilityBill_PaymentPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.UtilityBill_PaymentPlatform.dao.EmployeeDao;
import com.finzly.UtilityBill_PaymentPlatform.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	public String addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	public String checkEmployeeID(long employeeId) {
		Employee employee=employeeDao.checkEmployeeID(employeeId);
		if(employee==null) {
			return "Invalid User";
		}else {
			return "Valid User";
		}
	}

}