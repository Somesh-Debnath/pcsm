package com.pcms.pcms_backend.repository;
import com.pcms.pcms_backend.entity.Plans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlansRepository extends JpaRepository<Plans, Integer> {
    List<Plans> findByLocation(String location);

    List<Plans> findByPriceBetween(double minPrice, double maxPrice);
}