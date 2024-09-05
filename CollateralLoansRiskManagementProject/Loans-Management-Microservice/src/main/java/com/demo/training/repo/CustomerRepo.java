package com.demo.training.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.training.model.Customer;
/**
 * Customer Entity Curd Curd Repository
 */
@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {

}
