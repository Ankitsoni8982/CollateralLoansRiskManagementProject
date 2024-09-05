package com.demo.collaterals.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.collaterals.model.RealEstate;

/**
 * Repository for adding, fetching and manipulating Real Estate
 */
@Repository
public interface RealEstateRepository extends CrudRepository<RealEstate, Integer> {

}
