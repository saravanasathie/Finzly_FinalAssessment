package com.example.BBC.service;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.BBC.dao.CustomerDao;
import com.example.BBC.entity.Customer;
import com.example.BBC.entity.Transaction;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.common.record.Record;

package com.finzly.UtilityBill_PaymentPlatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.UtilityBill_PaymentPlatform.dao.CustomerDao;
import com.finzly.UtilityBill_PaymentPlatform.entity.CustomerData;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	public List<CustomerData> getAllCusomerData() {
		return customerDao.getAllCusomerData();
	}

}