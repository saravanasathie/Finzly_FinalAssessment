package com.example.BBC.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Transaction {

	@Id
	private long tId;
	private String transactionMethod;
	private double unitConsumption;
	private String status;
	private double totalAmount;
	private double discount;
	
	private Date startDate;
	private Date endDate;
	
	@OneToOne
	private Customer customer;
	
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	private double rate = 41.50;
	
	public void setRate(double rate) {
		this.rate = rate;
	}

	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getRate() {
		return rate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getUnitConsumption() {
		return unitConsumption;
	}

	public void setUnitConsumption(double unitConsumption) {
		this.unitConsumption = unitConsumption;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long gettId() {
		return tId;
	}


	public Transaction() {
		super();
	}

	public Transaction(long tId, String transactionMethod, double unitConsumption, String status, double totalAmount,
			double discount, Date startDate, Date endDate, double rate, Customer customer, String referenceNumber) {
		super();
		this.tId = tId;
		this.transactionMethod = transactionMethod;
		this.unitConsumption = unitConsumption;
		this.status = status;
		this.totalAmount = totalAmount;
		this.discount = discount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rate = rate;
		this.customer = customer;
		this.referenceNumber = referenceNumber;
	}

	public void settId(long tId) {
		this.tId = tId;
	}

	public String getTransactionMethod() {
		return transactionMethod;
	}

	public void setTransactionMethod(String transactionMethod) {
		this.transactionMethod = transactionMethod;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	private String referenceNumber;
	
}
