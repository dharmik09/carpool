package com.munifec.carpool.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.munifec.carpool.model.UserCar;

@Repository
public interface UserCarRepository extends CrudRepository<UserCar, Long> {
	@AllowFiltering
	public List<UserCar> findByUserId(long userId);
	
	public List<UserCar> findAll(Pageable pageable);
	
	public List<UserCar> findAll();
}
