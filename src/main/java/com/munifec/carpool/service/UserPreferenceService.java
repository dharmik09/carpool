package com.munifec.carpool.service;

import java.util.List;

import com.munifec.carpool.model.UserPreference;


public interface UserPreferenceService {
	
	public UserPreference createUserPref(UserPreference userPreferences);
	
	public UserPreference getPref(long id);
	
	public UserPreference updateUserPref(UserPreference userPreferences);
	
	public void deleteUserPref(long id);
	
	public List<UserPreference> getAllUserPref();
	
}
