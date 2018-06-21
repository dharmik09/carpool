package com.munifec.carpool.service;

import java.util.List;
import java.util.Map;

import com.munifec.carpool.model.User;
import com.munifec.carpool.model.UserPreference;

public interface UserService {

	public List<User> getUsersList();

	public User getUsersById(long userId);

	public void deleteUsersById(User user);

	public User saveUser(User user);

	public boolean saveFullUserProfile(User user, UserPreference preference);
	
	public Map<String,Object> getFullUserProfile(long userId);
}
