package com.munifec.carpool.service;

import java.util.List;

import com.munifec.carpool.model.UserCar;

public interface UserCarService {

	public List<UserCar> getUserCarList();

	public UserCar getUserCarsById(long userCarId);

	public void deleteUserCar(UserCar userCar);
	
	public void deleteUserCarById(long userCarId);

	public UserCar saveUserCar(UserCar userCar);
	
	public UserCar getUserCarsByUserId(long userId);
}
