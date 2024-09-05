package com.demo.collaterals.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.collaterals.exceptions.CollateralAlreadyExistsException;
import com.demo.collaterals.exceptions.CollateralNotFoundException;
import com.demo.collaterals.model.CashDeposit;
import com.demo.collaterals.model.Collateral;
import com.demo.collaterals.model.CollateralType;
import com.demo.collaterals.model.RealEstate;
import com.demo.collaterals.model.ReturnToRisk;
import com.demo.collaterals.repository.CashDepositRepository;
import com.demo.collaterals.repository.CollateralRepository;
import com.demo.collaterals.repository.RealEstateRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Service Implementation for Collateral management
 */
@Slf4j
@Service
public class CollateralServiceImpl implements CollateralService {

	@Autowired
	private CollateralRepository collateralRepository;

	@Autowired
	private RealEstateRepository realEstateRepository;

	@Autowired
	private CashDepositRepository cashDepositRepository;

	/**
	 * service layer for getCollaterals using loan id and customer id
	 * 
	 * @param loan id, customer id
	 * @return Collateral object
	 */
	public Collateral getCollaterals(Integer loanId, Integer customerId) {
		log.info("Get Collateral details using loan id and customer id");
		return collateralRepository.findById(loanId).orElseThrow(
				() -> new CollateralNotFoundException("Cannot find the collateral loan with id: " + loanId));
	}

	/**
	 * service layer for getCollateral using loan
	 * 
	 * @param loan id
	 * @return ReturnToRisk object-Response class object
	 */
	public ReturnToRisk getCollateral(Integer loanId) {
		ReturnToRisk returnToRisk = new ReturnToRisk();
		System.out.println("Inside Get Collateral method======================="+loanId);
				
		Collateral collateral = collateralRepository.findById(loanId).orElseThrow(
				() -> new CollateralNotFoundException("Cannot find the collateral loan with id: " + loanId));
		if (collateral.getCollateralType().equals(CollateralType.REAL_ESTATE)) {
			log.info("Get the Real Estate collateral Properties");
			RealEstate realEstate = (RealEstate) collateral;
			returnToRisk.setCollateralType(CollateralType.REAL_ESTATE);
			returnToRisk.setRatePerSqFt(realEstate.getRatePerSqFt());
			return returnToRisk;
		} else {
			log.info("Get the Cash Deposit collateral Properties");
			CashDeposit cashDeposit = (CashDeposit) collateral;
			returnToRisk.setCollateralType(CollateralType.CASH_DEPOSIT);
			returnToRisk.setInterestRate(cashDeposit.getInterestRate());
			return returnToRisk;
		}
	}

	/**
	 * service layer for saveRealEstateCollateral
	 * 
	 * @param RealEstate
	 * @return boolean value based on the collateral saved or not
	 */
	public boolean saveRealEstateCollateral(RealEstate realEstate) {
		boolean status = collateralRepository.existsById(realEstate.getLoanId());
		if (!status) {
			log.info("Real Estate Collateral details saved");
			realEstateRepository.save(realEstate);
			return true;
		} else {
			log.info("Real Estate Collateral already exists");
			throw new CollateralAlreadyExistsException(
					"Collateral already exists with loan id " + realEstate.getLoanId());
		}
	}

	/**
	 * service layer for saveCashDepositCollateral
	 * 
	 * @param CashDeposit
	 * @return boolean value based on the collateral saved or not
	 */
	public boolean saveCashDepositCollateral(CashDeposit cashDeposit) {
		boolean status = collateralRepository.existsById(cashDeposit.getLoanId());
		if (!status) {
			log.info("Cash Deposit Collateral details saved");
			cashDepositRepository.save(cashDeposit);
			return true;
		} else {
			log.info("Cash Deposit Collateral already exists");
			throw new CollateralAlreadyExistsException(
					"Collateral already exists with loan id " + cashDeposit.getLoanId());
		}
	}
}
