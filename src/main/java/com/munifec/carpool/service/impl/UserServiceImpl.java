package com.munifec.carpool.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.munifec.carpool.model.User;
import com.munifec.carpool.model.UserPreference;
import com.munifec.carpool.repository.UserPreferenceRepository;
import com.munifec.carpool.repository.UserRepository;
import com.munifec.carpool.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserPreferenceRepository userPreferenceRepository;

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
	public Map<String,Object> getFullUserProfile(long userId) {
		Map<String,Object> responseMap = new HashMap<String,Object>();
		User user = userRepository.findById(userId).get();
		List<UserPreference> userPreferenceList = userPreferenceRepository.findByUserId(userId);
		responseMap.put("user", user);
		responseMap.put("userPreference", userPreferenceList);		
		return responseMap;
	}

}
