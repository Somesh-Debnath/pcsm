package com.pcms.pcms_backend.repository;

import com.pcms.pcms_backend.entity.UserPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPlanRepository extends JpaRepository<UserPlans, Integer> {
    List<UserPlans> findByUserId(Long userId);
    List<UserPlans> findByAutoTerminatedFalse();
}