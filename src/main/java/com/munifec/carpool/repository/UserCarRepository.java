package com.munifec.carpool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.munifec.carpool.model.UserCar;

@Repository
public interface UserCarRepository extends CrudRepository<UserCar, Long> {
	public UserCar findByUserId(long userId);
}
