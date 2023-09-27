package com.example.BBC.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private long eId;
	private String name;
	
	private String password;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long geteId() {
		return eId;
	}
	public void seteId(long eId) {
		this.eId = eId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee(long eId, String name, String password) {
		
		this.eId = eId;
		this.name = name;
		this.password = password;
	}
	
	public Employee() {
		
	}
	
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", name=" + name + ", password=" + password + "]";
	}
	

	
}
