package com.techm.telecom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techm.telecom.model.Plan;
import com.techm.telecom.service.PlanService;

@RestController("/plan")
public class PlanController {

	@Autowired
	PlanService planService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Plan>> getAllPlanDetails() {
		return new ResponseEntity<List<Plan>>(planService.getAllPlanDetails(), HttpStatus.OK);
	} 
	
	@PostMapping("save/all")
	public ResponseEntity<List<Plan>> saveAllPlans(@RequestBody List<Plan> plans) {
		return new ResponseEntity<List<Plan>>(planService.saveAllPlans(plans), HttpStatus.CREATED);
	} 

}
