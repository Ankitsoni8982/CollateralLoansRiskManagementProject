package com.demo.training.service;

import org.springframework.http.ResponseEntity;

import com.demo.training.exception.CustomerLoanNotFoundException;
import com.demo.training.exception.LoanNotFoundException;
import com.demo.training.model.CustomerLoan;
import com.demo.training.pojo.CashDeposit;
import com.demo.training.pojo.RealEstate;

/**
 * LoanManagementService Interface for the loan management functionality
 */
public interface LoanManagementService {
	/**
	 * For Fetching the loan details
	 * @param loanId
	 * @param customerId
	 * @return CustomerLoan
	 * @throws CustomerLoanNotFoundException
	 */
	public CustomerLoan getLoanDetails(int loanId, int customerId) throws CustomerLoanNotFoundException;

	/**
	 * For Saving RealEstate Estate 
	 * @param token
	 * @param realEstate
	 * @return ResponseEntity/Status
	 * @throws CustomerLoanNotFoundException
	 * @throws LoanNotFoundException
	 */
	public ResponseEntity<String> saveRealEstate(String token, RealEstate realEstate)
			throws CustomerLoanNotFoundException, LoanNotFoundException;
	/**
	 * For Saving CashDeposit Estate
	 * @param token
	 * @param cashDeposit
	 * @return
	 * @throws CustomerLoanNotFoundException
	 * @throws LoanNotFoundException
	 */
	public ResponseEntity<String> saveCashDeposit(String token, CashDeposit cashDeposit)
			throws CustomerLoanNotFoundException, LoanNotFoundException;
}
