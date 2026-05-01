package com.techm.telecom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class MyBill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String billNumber;
	private String billDate;
	private String monthCharge;
	private String dueDate;
	private String startDate;
	private String endDate;
	
	/*
	 * @OneToOne(mappedBy = "myBill")
	 * 
	 * @JoinColumn(name = "my_account_id") private MyAccount myAccount;
	 */
	public MyBill() {
	}
	
	public MyBill(long id, String billNumber, String billDate, String monthCharge, String dueDate, String startDate,
			String endDate) {
		super();
		this.id = id;
		this.billNumber = billNumber;
		this.billDate = billDate;
		this.monthCharge = monthCharge;
		this.dueDate = dueDate;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getMonthCharge() {
		return monthCharge;
	}

	public void setMonthCharge(String monthCharge) {
		this.monthCharge = monthCharge;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/*
	 * public MyAccount getMyAccount() { return myAccount; }
	 * 
	 * public void setMyAccount(MyAccount myAccount) { this.myAccount = myAccount; }
	 */
	
}
