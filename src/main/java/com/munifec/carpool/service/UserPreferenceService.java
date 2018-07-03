package com.munifec.carpool.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.munifec.carpool.model.UserPreference;


public interface UserPreferenceService {
	
	public UserPreference saveUserPref(UserPreference userPreferences);
	
	public UserPreference getPref(long id);
	
	public UserPreference updateUserPref(UserPreference userPreferences);
	
	public void deleteUserPref(long id);
	
	public List<UserPreference> getAllUserPref(Pageable pageable);
	
	public List<UserPreference> getUserPreferences(long id);
	
}
