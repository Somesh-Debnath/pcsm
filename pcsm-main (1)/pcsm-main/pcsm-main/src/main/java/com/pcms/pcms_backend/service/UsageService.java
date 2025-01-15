package com.pcms.pcms_backend.service;
import com.pcms.pcms_backend.entity.Usage;
import com.pcms.pcms_backend.repository.UsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsageService {

    @Autowired
    private UsageRepository usageRepository;

    public List<Usage> getUsageByDateRange(Date from, Date to) {
        return usageRepository.findByUsageDateBetween(from, to);
    }
}