package com.munifec.carpool.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.munifec.carpool.images.exception.ImageStorageException;
import com.munifec.carpool.model.User;
import com.munifec.carpool.model.UserCar;
import com.munifec.carpool.model.UserPreference;
import com.munifec.carpool.repository.UserCarRepository;
import com.munifec.carpool.repository.UserPreferenceRepository;
import com.munifec.carpool.repository.UserRepository;
import com.munifec.carpool.service.ImagesService;
import com.munifec.carpool.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserPreferenceRepository userPreferenceRepository;

	@Autowired
	UserCarRepository userCarRepository;

	@Autowired
	ImagesService imagesService;

	@Override
	public List<User> getUsersList() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUsersById(long userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public User saveUser(User user) {

		return userRepository.save(user);

	}

	@Override
	public User saveUserWithImage(User user, MultipartFile file) {

		String imageName = null;
		try {
			imageName = imagesService.uploadImages(file, user.getId() + "");
		} catch (ImageStorageException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null != imageName) {
			// TODO Need to change to extension supplied by the user in original file
			user.setUserImage(imageName);
		}
		return userRepository.save(user);
	}

	@Override
	public void deleteUsersById(User user) {
		userRepository.delete(user);

	}

	@Override
	public boolean saveFullUserProfile(User user, UserPreference preference) {
		userRepository.save(user);
		userPreferenceRepository.save(preference);
		return true;
	}

	@Override
	public Map<String, Object> getFullUserProfile(long userId) {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		User user = userRepository.findById(userId).get();
		List<UserPreference> userPreferenceList = userPreferenceRepository.findByUserId(userId);
		List<UserCar> userCar = userCarRepository.findByUserId(userId);

		responseMap.put("user", user);
		responseMap.put("userPreference", userPreferenceList);
		responseMap.put("userCar", userCar);

		responseMap.put("userRatings", 4.5);
		return responseMap;
	}

	@Override
	public List<User> listAllByPage(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	/*
	 * @Override public List<User> getUserPage(int pageNumber) {
	 * CassandraPageRequest request = CassandraPageRequest.of(pageNumber, PAGESIZE,
	 * Sort.Direction.ASC);
	 * 
	 * return userRepository.findAll(request); }
	 */

}
