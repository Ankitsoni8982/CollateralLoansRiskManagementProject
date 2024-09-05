package com.demo.project.service;

import org.springframework.stereotype.Service;

import com.demo.project.exception.LoanNotFoundException;
import com.demo.project.pojo.CollateralRiskPercent;

/**
 * Service interface for Collateral Risk Service
 */
@Service
public interface CollateralRiskService {

	CollateralRiskPercent getRiskAssessment(String token, Integer loanId) throws LoanNotFoundException;

}
