package com.munifec.carpool.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.munifec.carpool.model.UserCar;

public interface UserCarService {

	public UserCar getUserCarsById(long userCarId);

	public void deleteUserCar(UserCar userCar);

	public void deleteUserCarById(long userCarId);

	public UserCar saveUserCar(UserCar userCar);

	public List<UserCar> getUserCarsByUserId(long userId);

	public List<UserCar> getAllCar();

	public UserCar saveUserCarWithImage(UserCar userCar, MultipartFile file);

	public List<UserCar> getUserCarList(Pageable pageable);

}
