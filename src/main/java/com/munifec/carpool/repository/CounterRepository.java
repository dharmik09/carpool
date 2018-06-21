package com.munifec.carpool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.munifec.carpool.model.DBIDCounter;

@Repository
public interface CounterRepository extends CrudRepository<DBIDCounter, String> {
	
}
