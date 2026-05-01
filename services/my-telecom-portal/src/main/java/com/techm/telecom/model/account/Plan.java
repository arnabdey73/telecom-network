package com.techm.telecom.model.account;

import java.util.Map;

public class Plan {

	private long id;
	private String name;
	private Map<String, String> packs;
	private MyPlan myPlan;

	public Plan() {
	}

	public Plan(long id, String name, Map<String, String> packs) {
		super();
		this.id = id;
		this.name = name;
		this.packs = packs;
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

	public Map<String, String> getPacks() {
		return packs;
	}

	public void setPacks(Map<String, String> packs) {
		this.packs = packs;
	}

	public MyPlan getMyPlan() {
		return myPlan;
	}

	public void setMyPlan(MyPlan myPlan) {
		this.myPlan = myPlan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((myPlan == null) ? 0 : myPlan.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((packs == null) ? 0 : packs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plan other = (Plan) obj;
		if (id != other.id)
			return false;
		if (myPlan == null) {
			if (other.myPlan != null)
				return false;
		} else if (!myPlan.equals(other.myPlan))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (packs == null) {
			if (other.packs != null)
				return false;
		} else if (!packs.equals(other.packs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", name=" + name + ", packs=" + packs + ", myPlan=" + myPlan + "]";
	}
	
}
