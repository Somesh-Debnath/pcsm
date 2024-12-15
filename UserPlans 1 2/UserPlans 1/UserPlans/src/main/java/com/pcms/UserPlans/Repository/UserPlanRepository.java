package com.pcms.UserPlans.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcms.UserPlans.Model.Plans;

public interface UserPlanRepository extends JpaRepository<Plans, Long>{

	

}
