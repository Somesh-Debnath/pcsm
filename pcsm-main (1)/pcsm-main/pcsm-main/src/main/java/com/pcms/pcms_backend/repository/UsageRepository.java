package com.pcms.pcms_backend.repository;

import com.pcms.pcms_backend.entity.Usage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UsageRepository extends JpaRepository<Usage, Integer> {
    List<Usage> findByUsageDateBetween(Date from, Date to);
}