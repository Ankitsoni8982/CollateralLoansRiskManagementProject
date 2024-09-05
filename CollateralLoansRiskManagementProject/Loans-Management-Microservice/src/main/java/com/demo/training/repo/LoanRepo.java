package com.demo.training.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.training.model.Loan;

/**
 * Loan Entity Curd Repository
 */
@Repository
public interface LoanRepo extends CrudRepository<Loan, Integer> {

}
