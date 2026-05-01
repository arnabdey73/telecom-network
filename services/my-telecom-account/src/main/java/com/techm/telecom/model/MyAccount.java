package com.techm.telecom.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class MyAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String myPhone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private MyUsage myUsage;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private MyBill myBill;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private MyPlan myPlan;

	public MyAccount() {}
	
	public MyAccount(long id, String myPhone, MyUsage myUsage, MyBill myBill, MyPlan myPlan) {
		super();
		this.id = id;
		this.myPhone = myPhone;
		this.myUsage = myUsage;
		this.myBill = myBill;
		this.myPlan = myPlan;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMyPhone() {
		return myPhone;
	}

	public void setMyPhone(String myPhone) {
		this.myPhone = myPhone;
	}

	public MyUsage getMyUsage() {
		return myUsage;
	}

	public void setMyUsage(MyUsage myUsage) {
		this.myUsage = myUsage;
	}

	public MyBill getMyBill() {
		return myBill;
	}

	public void setMyBill(MyBill myBill) {
		this.myBill = myBill;
	}

	public MyPlan getMyPlan() {
		return myPlan;
	}

	public void setMyPlan(MyPlan myPlan) {
		this.myPlan = myPlan;
	}
	
}
