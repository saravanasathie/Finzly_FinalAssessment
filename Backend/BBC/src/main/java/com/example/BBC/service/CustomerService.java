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


@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	SessionFactory factory;
	
	private Date date = new Date();
	
	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}
	
	public List<Customer> getCustomerId(long id) {
		List<Customer> customers = customerDao.getCustomerId(id);
		List<Customer> al = new ArrayList<>();
		for (Customer customer : customers) {
			if(customer.getCid() == id) {
				al.add(customer);
				return al;
			}
		}
		return null;
	}
	
	public String addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}
	
	public List<Customer> uploadCustomerData(MultipartFile file) throws Exception {
	    Session session = factory.openSession();
	    org.hibernate.Transaction outerTransaction = null;
	    List<Customer> customerBillDatas = new ArrayList<>();

	    try (InputStream inputStream = file.getInputStream()) {
	        CsvParserSettings settings = new CsvParserSettings();
	        settings.setHeaderExtractionEnabled(true);
	        CsvParser parser = new CsvParser(settings);

	        List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
	        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy H:mm");

	        outerTransaction = session.beginTransaction(); // Start the outer transaction

	        for (Record record : parseAllRecords) {
	            Customer customerBillData = new Customer();
	            customerBillData.setName(record.getString("name"));
	            customerBillData.setCid(Long.parseLong(record.getString("cid")));

	            long transactionId = Long.parseLong(record.getString("transaction_t_id"));
	            Transaction transactionEntity = session.get(Transaction.class, transactionId);

	            if (transactionEntity == null) {
	                transactionEntity = new Transaction();
	                transactionEntity.settId(transactionId);
	            }

	            try {
	                customerBillData.setTransaction(transactionEntity);

	                // Set other properties of transactionEntity
	                transactionEntity.setUnitConsumption(Double.parseDouble(record.getString("unit_consumed")));
	                transactionEntity.setTransactionMethod(record.getString("transaction_method"));

	                // Parse and set dates
	                String billStartDate = record.getString("start_date");
	                java.util.Date utilDate = dateFormat.parse(billStartDate);
	                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	                transactionEntity.setStartDate(sqlDate);

	                String billDueDate = record.getString("end_date");
	                java.util.Date utilDate1 = dateFormat.parse(billDueDate);
	                java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
	                transactionEntity.setEndDate(sqlDate1);

	                customerBillData.setEmailId(record.getString("email_id"));
	                customerBillData.setPhoneNumber(record.getString("phone_number"));

	                // Save or update the CustomerData entity (due to cascading, this will also save/update the associated transaction)
	                session.saveOrUpdate(customerBillData);

	                customerBillDatas.add(customerBillData);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        outerTransaction.commit(); 
	    } catch (Exception e) {
	        e.printStackTrace();
	        if (outerTransaction != null) {
	            outerTransaction.rollback(); 
	        }
	    } finally {
	        session.close(); // Close the Hibernate session
	    }

	    return customerBillDatas;
	}

	
	
	
}
