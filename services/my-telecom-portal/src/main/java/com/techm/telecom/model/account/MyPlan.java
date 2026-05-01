package com.techm.telecom.model.account;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyPlan {

	private long id;
	private String name;
	private Set<Plan> allPlans;

	public MyPlan() {
	}

	public MyPlan(long id, String name, Set<Plan> allPlans) {
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

	public Set<Plan> getAllPlans() {
		return allPlans;
	}

	public void setAllPlans(Set<Plan> allPlans) {
		this.allPlans = allPlans;
	}

	@Override
	public String toString() {
		return "MyPlan [id=" + id + ", name=" + name + ", allPlans=" + allPlans + "]";
	}

}
