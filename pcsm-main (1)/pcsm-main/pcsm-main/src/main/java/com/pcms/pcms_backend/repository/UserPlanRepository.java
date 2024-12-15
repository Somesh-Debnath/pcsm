package com.pcms.pcms_backend.repository;


import com.pcms.pcms_backend.entity.Plans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPlanRepository extends JpaRepository<Plans, Long> {


}
