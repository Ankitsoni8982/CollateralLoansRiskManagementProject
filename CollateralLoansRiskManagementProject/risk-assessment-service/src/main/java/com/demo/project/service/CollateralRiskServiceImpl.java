package com.demo.project.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.project.exception.LoanNotFoundException;
import com.demo.project.feign.CollateralFeign;
import com.demo.project.model.CollateralInterestRate;
import com.demo.project.model.CollateralMarketValue;
import com.demo.project.pojo.CollateralRiskPercent;
import com.demo.project.pojo.CollateralType;
import com.demo.project.pojo.ReturnToRisk;
import com.demo.project.repository.CollateralInterestRateRepo;
import com.demo.project.repository.CollateralMarketValueRepo;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

/**
 * Service Implementation for Collateral risk service
 */
@Slf4j
@Service
public class CollateralRiskServiceImpl implements CollateralRiskService {

	@Autowired
	private CollateralFeign client;

	@Autowired
	private CollateralMarketValueRepo collateralMarketValueRepo;

	@Autowired
	private CollateralInterestRateRepo collateralInterestRateRepo;

	/**
	 * service layer for getRiskAssessment using loan id
	 * 
	 * @param loan id
	 * @return CollateralRiskPercent
	 */
	@Override
	public CollateralRiskPercent getRiskAssessment(String token, Integer loanId) throws LoanNotFoundException {
		CollateralRiskPercent collateralRiskPercent = new CollateralRiskPercent();
		
		System.out.println("===========inside Collateral Service IMPL============="+loanId);
		try {
			//Need to check from here
			ReturnToRisk returnToRisk = client.getCollateralWithLoanId(token, loanId);

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date(System.currentTimeMillis());
			collateralRiskPercent.setAssessedDate(formatter.format(date));

			Double previousRate;
			if ((returnToRisk.getCollateralType().equals(CollateralType.REAL_ESTATE))) {
				log.info("Get Risk Percentage for Real Estate collateral");
				previousRate = returnToRisk.getRatePerSqFt();
				CollateralMarketValue presentRate = collateralMarketValueRepo.findById(1).orElse(null);

				if (presentRate != null && (previousRate < presentRate.getRatePerSqrFeet())) {
					double riskPercent = Math.abs(
							((previousRate - presentRate.getRatePerSqrFeet()) / presentRate.getRatePerSqrFeet()) * 100);
					collateralRiskPercent.setRiskPercent(riskPercent);
					return collateralRiskPercent;
				} else {
					collateralRiskPercent.setRiskPercent((double) 0);
					return collateralRiskPercent;
				}
			} else {
				log.info("Get Risk Percentage for Cash Deposit collateral");
				previousRate = returnToRisk.getInterestRate();
				CollateralInterestRate presentRate = collateralInterestRateRepo.findById(1).orElse(null);
				if (presentRate != null && (previousRate < presentRate.getInterestRate())) {
					double riskPercent = Math.abs(
							((previousRate - presentRate.getInterestRate()) / presentRate.getInterestRate()) * 100);
					collateralRiskPercent.setRiskPercent(riskPercent);
					return collateralRiskPercent;
				} else {
					collateralRiskPercent.setRiskPercent((double) 0);
					return collateralRiskPercent;
				}

			}
		} catch (FeignException e) {
			e.printStackTrace();
			throw new LoanNotFoundException("Loan ID not found");
		}
	}
}
