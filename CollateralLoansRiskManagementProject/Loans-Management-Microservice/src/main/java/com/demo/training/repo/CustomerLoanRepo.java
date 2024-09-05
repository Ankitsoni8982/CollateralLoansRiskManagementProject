package com.demo.training.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.training.model.CustomerLoan;

/**
 * Customer Loan Curd Repository 
 */
@Repository
public interface CustomerLoanRepo extends CrudRepository<CustomerLoan, Integer> {

}
