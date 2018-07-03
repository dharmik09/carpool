package com.munifec.carpool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.munifec.carpool.model.UserPreference;
import com.munifec.carpool.repository.UserPreferenceRepository;
import com.munifec.carpool.service.UserPreferenceService;

@Service
public class UserPreferenceServiceImpl implements UserPreferenceService {

	@Autowired
	UserPreferenceRepository userPreferenceRepository;

	public UserPreferenceServiceImpl() {
	}

	@Override
	public UserPreference saveUserPref(UserPreference userPreferences) {
		return userPreferenceRepository.save(userPreferences);
	}

	@Override
	public UserPreference getPref(long id) {
		return userPreferenceRepository.findById(id).get();
	}

	@Override
	public UserPreference updateUserPref(UserPreference userPreferences) {
		return userPreferenceRepository.save(userPreferences);
	}

	@Override
	public void deleteUserPref(long id) {
		UserPreference pref = getPref(id);
		userPreferenceRepository.delete(pref);
	}

	@Override
	public List<UserPreference> getAllUserPref(Pageable pageable) {
		return userPreferenceRepository.findAll(pageable);
	}

	@Override
	public List<UserPreference> getUserPreferences(long userId) {
		return userPreferenceRepository.findByUserId(userId);

	}

}
