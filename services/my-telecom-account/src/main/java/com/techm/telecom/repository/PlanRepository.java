package com.techm.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techm.telecom.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

}
