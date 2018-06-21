package com.munifec.carpool.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.munifec.carpool.constants.CounterConstants;
import com.munifec.carpool.model.User;
import com.munifec.carpool.model.UserPreference;
import com.munifec.carpool.service.UserService;
import com.munifec.carpool.util.OTPGenerator;

@RestController
@RequestMapping("api/user")
public class UserController extends AbstractRestController implements BasicAppController<User>{

	final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;

	@GetMapping("/list")
	public List<User> list() {
		log.info("user to registered : ");
		return userService.getUsersList();
	}
	
	@PostMapping("/insert")
	public User insert(User user) {
		log.info("user to registered : " + user);
		//Get counter value from db for key column for Insert
		user.setId(getIdForNewObject(CounterConstants.USER_COUNTER));
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		user.setCreatedTime(time);	
		user.setCreatedBy(getUserNameForLoggedInUser());	
		return userService.saveUser(user);
	}
	
	@PostMapping("/update")
	public User update(User user) {
		log.info("user to be updated : " + user);

		checkForNull(user);
		user.setModifiedTime(new Date());
		user.setModifiedBy(getUserNameForLoggedInUser());	
		return userService.saveUser(user);
	}	

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable("id") long userId) {
		log.info("Get user by id in edit: ");
		User user = userService.getUsersById(userId);
		boolean isDeleted = false;
		if (user != null) {
			userService.deleteUsersById(user);
			isDeleted = true;
		}
		return isDeleted;
	}
	
	@GetMapping("/view/{id}")
	public User view(@PathVariable("id") long userId){
		log.info("Get user by id in edit: ");
		return userService.getUsersById(userId);
	}
	

	@PostMapping("/update-profile")
	public User updateUserProfile(User user) {
		
		log.info("calling userProfile mapping");		
		checkForNull(user);		
		String fname=user.getFirstName();
		String lname=user.getLastName();
		String pinfo=user.getPersionalInfo();
		String mobile=user.getMobile();
		
		//below code is to update only allowed fields only
		Long userId = user.getId();
		User updatableUser = userService.getUsersById(userId);
		updatableUser.setFirstName(fname);
		updatableUser.setLastName(lname);		
		updatableUser.setPersionalInfo(pinfo);
		updatableUser.setMobile(mobile);		
		updatableUser.setModifiedTime(new Date());
		updatableUser.setModifiedBy(getUserNameForLoggedInUser());
		return userService.saveUser(updatableUser);
	}
	
	@PostMapping("/update-full-profile")
	public boolean updateFullUserProfile(User user, UserPreference userPreference) {		
		log.info("calling updateFullUserProfile mapping");		
		checkForNull(user);		
		String fname=user.getFirstName();
		String lname=user.getLastName();
		String pinfo=user.getPersionalInfo();
		String mobile=user.getMobile();		
		//below code is to update only allowed fields only
		Long userId = user.getId();
		User updatableUser = userService.getUsersById(userId);
		updatableUser.setFirstName(fname);
		updatableUser.setLastName(lname);		
		updatableUser.setPersionalInfo(pinfo);
		updatableUser.setMobile(mobile);		
		updatableUser.setModifiedTime(new Date());
		updatableUser.setModifiedBy(getUserNameForLoggedInUser());
		
		
		return userService.saveFullUserProfile(updatableUser, userPreference);				
	}
	
	@GetMapping("/get-full-profile/{userId}")
	public ResponseEntity<Map<String, Object>> getFullUserProfile(@PathVariable("userId") long userId){
		return new ResponseEntity<>(userService.getFullUserProfile(userId),HttpStatus.OK);
	}
	
	//TODO For now as we don't have SMS api, for testing purpose we are returning value, else it will be void
	@PostMapping("/request-code")
	public Integer getOTP(long userId, String mobile) {		
		Integer otp = OTPGenerator.generateOTP();	
		//TODO Need to generate random OTP and send SMS later, when we get SMS api
		User user = userService.getUsersById(userId);
		user.setOtp(otp.toString());
		user.setOtpCreationTime(new Date());
		
		userService.saveUser(user);
		return otp;		
	}
	
	@PostMapping("/verify-code")
	public Boolean verifyOTP(Long userId, String otp) {		
		User user = userService.getUsersById(userId);
		return otp.equals(user.getOtp());
	}

	private void checkForNull(User user) {
		if(null == user || null == user.getId()){
			throw new IllegalArgumentException("User id is mandatory for update");
		}
	}
	
}
