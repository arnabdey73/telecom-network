package com.techm.telecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.telecom.model.MyAccount;
import com.techm.telecom.model.MyPlan;
import com.techm.telecom.model.Plan;
import com.techm.telecom.repository.MyAccountRepository;
import com.techm.telecom.repository.PlanRepository;

@Service
public class MyAccountService {

	@Autowired
	private MyAccountRepository myAccountRepository;

	@Autowired
	private PlanRepository planRepository;

	public List<MyAccount> getMyAccountDetails() {
		List<MyAccount> myAccounts = myAccountRepository.findAll();
		List<Plan> plans = planRepository.findAll();
		for (MyAccount myAccount : myAccounts) {
			myAccount.getMyPlan().setAllPlans(plans);
		}
		return myAccounts;
	}

	public List<MyAccount> getMyAccountByMyPhone(String myPhone) {
		List<MyAccount> myAccounts = myAccountRepository.getMyAccountByMyPhone(myPhone);
		List<Plan> plans = planRepository.findAll();
		for (MyAccount myAccount : myAccounts) {
			myAccount.getMyPlan().setAllPlans(plans);
		}
		return myAccounts;
	}

	public MyAccount updateNewPlan(long accountId, long planId) {
		MyAccount myAccountNew = myAccountRepository.findById(accountId).get();
		Plan planNew = planRepository.findById(planId).get();
		List<Plan> allPlans = planRepository.findAll();
		MyPlan myPlanNew = new MyPlan(myAccountNew.getMyPlan().getId(), planNew.getName(), allPlans);
		myAccountNew.setMyPlan(myPlanNew);
		return myAccountRepository.save(myAccountNew);
	}

	public List<MyAccount> saveAccountForMultipleUsers(List<MyAccount> myAccounts) {
		return myAccountRepository.saveAll(myAccounts);
	}

	public MyAccount saveAccountForSingleUser(MyAccount myAccount) {
		return myAccountRepository.save(myAccount);
	}

}
