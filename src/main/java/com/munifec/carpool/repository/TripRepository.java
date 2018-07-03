package com.munifec.carpool.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.munifec.carpool.model.Trip;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long>{
	public List<Trip> findAll(Pageable pageable);
	
	public List<Trip> findAll();
}
