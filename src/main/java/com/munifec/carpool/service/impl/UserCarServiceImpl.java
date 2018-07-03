package com.munifec.carpool.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.munifec.carpool.images.exception.ImageStorageException;
import com.munifec.carpool.model.UserCar;
import com.munifec.carpool.repository.UserCarRepository;
import com.munifec.carpool.service.ImagesService;
import com.munifec.carpool.service.UserCarService;

@Service
@Transactional
public class UserCarServiceImpl implements UserCarService {

	@Autowired
	private UserCarRepository userCarRepository;

	@Autowired
	ImagesService imagesService;

	@Override
	public List<UserCar> getAllCar() {

		return userCarRepository.findAll();
	}

	@Override
	public List<UserCar> getUserCarList(Pageable pageable) {
		return userCarRepository.findAll(pageable);
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
	public List<UserCar> getUserCarsByUserId(long userId) {
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

	@Override
	public UserCar saveUserCarWithImage(UserCar userCar, MultipartFile file) {
		String imageName = null;
		try {
			imageName = imagesService.uploadImages(file, userCar.getUserCarId() + "");
		} catch (ImageStorageException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null != imageName) {
			// TODO Need to change to extension supplied by the user in original file
			userCar.setUserCarImage(imageName);
		}
		return userCarRepository.save(userCar);
	}

}
