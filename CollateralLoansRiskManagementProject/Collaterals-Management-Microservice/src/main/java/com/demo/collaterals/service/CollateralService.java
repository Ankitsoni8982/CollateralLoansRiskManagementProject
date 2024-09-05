package com.demo.collaterals.service;

import org.springframework.stereotype.Service;

import com.demo.collaterals.model.CashDeposit;
import com.demo.collaterals.model.Collateral;
import com.demo.collaterals.model.RealEstate;
import com.demo.collaterals.model.ReturnToRisk;

/**
 * Service interface for Collateral Management
 */
@Service
public interface CollateralService {

	public ReturnToRisk getCollateral(Integer loanId);

	public boolean saveRealEstateCollateral(RealEstate realEstate);

	public boolean saveCashDepositCollateral(CashDeposit cashDeposit);

	public Collateral getCollaterals(Integer loanId, Integer customerId);
}
