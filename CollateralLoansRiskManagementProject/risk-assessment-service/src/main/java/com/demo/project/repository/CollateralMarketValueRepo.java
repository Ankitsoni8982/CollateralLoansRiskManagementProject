package com.demo.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.project.model.CollateralMarketValue;

/**
 * Repository for adding, fetching and manipulating CollateralMarketValueRepo
 */
@Repository
public interface CollateralMarketValueRepo extends CrudRepository<CollateralMarketValue, Integer> {

}
