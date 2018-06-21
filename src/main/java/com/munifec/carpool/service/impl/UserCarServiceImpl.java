package com.munifec.carpool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.munifec.carpool.model.UserCar;
import com.munifec.carpool.repository.UserCarRepository;
import com.munifec.carpool.service.UserCarService;

@Service
@Transactional
public class UserCarServiceImpl implements UserCarService {

	@Autowired
	private UserCarRepository userCarRepository;
	
	@Override
	public List<UserCar> getUserCarList() {
		return (List<UserCar>)userCarRepository.findAll();
	}

	@Override
	public UserCar getUserCarsById(long userCarId) {
		return userCarRepository.findById(userCarId).get();
	}

	@Override
	public UserCar saveUserCar(UserCar userCar) {
		return userCarRepository.save(userCar);
	}

	@Override
	public UserCar getUserCarsByUserId(long userId) {
		return userCarRepository.findByUserId(userId);
	}

	@Override
	public void deleteUserCar(UserCar userCar) {
		userCarRepository.delete(userCar);
	}

	@Override
	public void deleteUserCarById(long userCarId) {
		userCarRepository.deleteById(userCarId);
	}

	

}
