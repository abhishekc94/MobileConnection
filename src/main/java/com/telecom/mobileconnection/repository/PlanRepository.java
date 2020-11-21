package com.telecom.mobileconnection.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.mobileconnection.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer>{
	
	public Optional<Plan> findByPlanId(Integer planId);

}
