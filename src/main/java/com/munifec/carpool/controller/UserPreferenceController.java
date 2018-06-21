package com.munifec.carpool.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.munifec.carpool.constants.CounterConstants;
import com.munifec.carpool.model.UserPreference;
import com.munifec.carpool.service.UserPreferenceService;

@RestController
@RequestMapping("/api/preference")
public class UserPreferenceController extends AbstractRestController implements BasicAppController<UserPreference> {

	final Logger log = LoggerFactory.getLogger(UserPreferenceController.class);

	@Autowired
	private UserPreferenceService service;

	public UserPreferenceController() {
		System.out.println("UserPreferenceController");
	}

	@PostMapping("/insert")
	public UserPreference insert(UserPreference userPreference) {
		log.info("This is calling create userPreference mapping");
		
		if(null == userPreference.getUserId()){
			throw new IllegalArgumentException("User id is mandatory to set user preference");
		}
		//Get counter value from db for key column for Insert
		userPreference.setUserPreferenceId(getIdForNewObject(CounterConstants.USER_PREFRENCE_COUNTER));
		userPreference.setCreatedBy(getUserNameForLoggedInUser());
		userPreference.setCreatedTime(new Date());
		return service.createUserPref(userPreference);
	}

	@GetMapping("/view/{id}")
	public UserPreference view(@PathVariable long id) {
		log.info("calling get by id userPreference mapping");
		return service.getPref(id);
	}

	@GetMapping("/list")
	public List<UserPreference> list() {
		log.info("This is calling get all userPreference mapping");
		return service.getAllUserPref();
	}

	@PostMapping("/update")
	public UserPreference update(UserPreference userPreferences) {
		log.info("calling update userPreference mapping");
		checkForNull(userPreferences);
		userPreferences.setModifiedBy(getUserNameForLoggedInUser());
		userPreferences.setModifiedTime(new Date());
		return service.updateUserPref(userPreferences);

	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		log.info("calling  delete by id userPreference mapping");
		UserPreference preferences = service.getPref(id);
		boolean isDeleted = false;
		if (preferences != null) {
			service.deleteUserPref(id);
			isDeleted = true;
		}
		return isDeleted;
	}

	private void checkForNull(UserPreference userPreferences) {
		if (null == userPreferences || null == userPreferences.getUserPreferenceId()) {
			throw new IllegalArgumentException("Please provide proper JSON for User");
		}
	}

}
