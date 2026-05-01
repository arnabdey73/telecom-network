package com.techm.telecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.telecom.model.Plan;
import com.techm.telecom.repository.PlanRepository;

@Service
public class PlanService {
	
	@Autowired
	PlanRepository planRepository;
	
	public List<Plan> getAllPlanDetails(){
		return planRepository.findAll();
	}
	
	public List<Plan> saveAllPlans(List<Plan> plans){
		return planRepository.saveAll(plans);
	}
	
}
