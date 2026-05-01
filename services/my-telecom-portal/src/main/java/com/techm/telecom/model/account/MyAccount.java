package com.techm.telecom.model.account;

public class MyAccount {

	private long id;
	private String myPhone;
	private String userName;
	private MyUsage myUsage;
	private MyBill myBill;
	private MyPlan myPlan;

	public MyAccount() {
	}

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "MyAccount [id=" + id + ", myPhone=" + myPhone + ", myUsage=" + myUsage + ", myBill=" + myBill
				+ ", myPlan=" + myPlan + "]";
	}
}
