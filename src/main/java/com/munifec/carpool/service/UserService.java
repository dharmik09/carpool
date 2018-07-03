package com.munifec.carpool.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.munifec.carpool.model.User;
import com.munifec.carpool.model.UserPreference;

public interface UserService {

	public List<User> getUsersList();

	public User getUsersById(long userId);

	public void deleteUsersById(User user);

	public User saveUser(User user);

	public boolean saveFullUserProfile(User user, UserPreference preference);

	public Map<String, Object> getFullUserProfile(long userId);

	public User saveUserWithImage(User user, MultipartFile file);

	public List<User> listAllByPage(Pageable pageable);

	//List<User> getUserPage(int pageNumber);


}
