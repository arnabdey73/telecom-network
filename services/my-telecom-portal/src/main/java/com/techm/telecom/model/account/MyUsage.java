package com.techm.telecom.model.account;

public class MyUsage {

	private long id;

	private double amount;
	private int smsQuota;
	private int usedSMS;
	private double internetQuota;
	private double usedInternet;
	private double availInternet;
	private String dataUnit;

	public MyUsage() {
	}

	public MyUsage(long id, double amount, int smsQuota, int usedSMS, double internetQuota, double usedInternet,
			double availInternet, String dataUnit) {
		super();
		this.id = id;
		this.amount = amount;
		this.smsQuota = smsQuota;
		this.usedSMS = usedSMS;
		this.internetQuota = internetQuota;
		this.usedInternet = usedInternet;
		this.availInternet = availInternet;
		this.dataUnit = dataUnit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getSmsQuota() {
		return smsQuota;
	}

	public void setSmsQuota(int smsQuota) {
		this.smsQuota = smsQuota;
	}

	public int getUsedSMS() {
		return usedSMS;
	}

	public void setUsedSMS(int usedSMS) {
		this.usedSMS = usedSMS;
	}

	public double getInternetQuota() {
		return internetQuota;
	}

	public void setInternetQuota(double internetQuota) {
		this.internetQuota = internetQuota;
	}

	public double getUsedInternet() {
		return usedInternet;
	}

	public void setUsedInternet(double usedInternet) {
		this.usedInternet = usedInternet;
	}

	public double getAvailInternet() {
		return availInternet;
	}

	public void setAvailInternet(double availInternet) {
		this.availInternet = availInternet;
	}

	public String getDataUnit() {
		return dataUnit;
	}

	public void setDataUnit(String dataUnit) {
		this.dataUnit = dataUnit;
	}

	@Override
	public String toString() {
		return "MyUsage [id=" + id + ", amount=" + amount + ", smsQuota=" + smsQuota + ", usedSMS=" + usedSMS
				+ ", internetQuota=" + internetQuota + ", usedInternet=" + usedInternet + ", availInternet="
				+ availInternet + ", dataUnit=" + dataUnit + "]";
	}
}
