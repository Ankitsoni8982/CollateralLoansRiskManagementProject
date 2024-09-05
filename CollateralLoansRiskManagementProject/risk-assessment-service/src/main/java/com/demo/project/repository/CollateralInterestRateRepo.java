package com.demo.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.project.model.CollateralInterestRate;

/**
 * Repository for adding, fetching and manipulating Collateral Interest Rate
 * Repo
 */
@Repository
public interface CollateralInterestRateRepo extends CrudRepository<CollateralInterestRate, Integer> {

}
