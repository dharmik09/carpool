package com.munifec.carpool.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.munifec.carpool.model.TripRequest;

@Repository
public interface TripRequestRepository extends CrudRepository<TripRequest, Long> {
		
	public List<TripRequest> findAll(Pageable pageable);
	
	@Query("SELECT * FROM TripRequest where userId = ?0 ALLOW FILTERING")
	public List<TripRequest> findByUserId(long id);
	
	public List<TripRequest> findAll();
}
