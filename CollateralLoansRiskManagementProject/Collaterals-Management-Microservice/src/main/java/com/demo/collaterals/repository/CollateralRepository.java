package com.demo.collaterals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.collaterals.model.Collateral;

/**
 * Repository for adding, fetching and manipulating Collateraal
 */
@Repository
public interface CollateralRepository extends JpaRepository<Collateral, Integer> {

}
