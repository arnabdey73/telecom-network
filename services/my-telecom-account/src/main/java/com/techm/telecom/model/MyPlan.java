package com.techm.telecom.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class MyPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@OneToMany(targetEntity=Plan.class, mappedBy="myPlan", fetch=FetchType.EAGER)
	private List<Plan> allPlans;
	
	/*
	 * @OneToOne(mappedBy = "myPlan")
	 * 
	 * @JoinColumn(name = "my_account_id") private MyAccount myAccount;
	 */

	public MyPlan() {
	}
	
	public MyPlan(long id, String name, List<Plan> allPlans) {
		super();
		this.id = id;
		this.name = name;
		this.allPlans = allPlans;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Plan> getAllPlans() {
		return allPlans;
	}

	public void setAllPlans(List<Plan> allPlans) {
		this.allPlans = allPlans;
	}

}
