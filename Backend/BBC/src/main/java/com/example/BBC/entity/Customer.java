package com.example.BBC.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Customer {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cid;
	private String name;
	private String phoneNumber;
	private String emailId;
	
//	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Transaction transaction;
	
	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public Customer() {
		
	}

	public Customer(long cid, String name, String phoneNumber, String emailId) {
		super();
		this.cid = cid;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId
				+ ", transaction="+"]";
	}
			
}
