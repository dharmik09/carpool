package com.munifec.carpool.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.munifec.carpool.constants.CounterConstants;
import com.munifec.carpool.constants.MessageConstants;
import com.munifec.carpool.model.UserCar;
import com.munifec.carpool.model.UserPreference;
import com.munifec.carpool.response.CarpoolResponse;
import com.munifec.carpool.service.UserCarService;
import com.munifec.carpool.service.UserPreferenceService;

@RestController
public class UserPreferenceController extends AbstractRestController implements BasicAppController<UserPreference> {

	final Logger log = LoggerFactory.getLogger(UserPreferenceController.class);

	@Autowired
	private UserPreferenceService userPreferenceservice;

	@Autowired
	private UserCarService userCarService;

	public UserPreferenceController() {
		System.out.println("UserPreferenceController");
	}

	@PostMapping("/insert")
	public CarpoolResponse insert(UserPreference userPreference, MultipartFile file) {
		log.info("This is calling create userPreference mapping");

		if (null == userPreference.getUserId()) {
			throw new IllegalArgumentException("User id is mandatory to set user preference");
		}
		// Get counter value from db for key column for Insert
		userPreference.setUserPreferenceId(getIdForNewObject(CounterConstants.USER_PREFRENCE_COUNTER));
		userPreference.setCreatedBy(getUserNameForLoggedInUser());
		userPreference.setCreatedTime(new Date());
		userPreference = userPreferenceservice.saveUserPref(userPreference);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("savePref", userPreference);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@GetMapping("/list") // for list
	public CarpoolResponse list(Pageable pageable) {
		log.info("This is calling list userPreference mapping");
		List<UserPreference> prefList = userPreferenceservice.getAllUserPref(pageable);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("listPref", prefList);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@PostMapping("/user/preferences") // for update
	public CarpoolResponse update(UserPreference userPreferences) {
		log.info("calling update userPreference mapping");
		checkForNull(userPreferences);
		userPreferences.setModifiedBy(getUserNameForLoggedInUser());
		userPreferences.setModifiedTime(new Date());
		userPreferences = userPreferenceservice.saveUserPref(userPreferences);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("updatePref", userPreferences);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_USERPREFERENCE_FOR_UPDATE, dataMap, metaDataMap);

	}

	@GetMapping("/preference/{id}") // for view by is
	public CarpoolResponse view(@PathVariable long id) {
		log.info("calling get by id userPreference mapping");
		UserPreference preferences = userPreferenceservice.getPref(id);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("viewPref", preferences);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@DeleteMapping("/preference/{id}") // for delete
	public CarpoolResponse delete(@PathVariable long id) {
		log.info("calling  delete by id userPreference mapping");
		UserPreference preferences = userPreferenceservice.getPref(id);

		userPreferenceservice.deleteUserPref(id);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_USERPREFERENCE_FOR_DELETE, dataMap, metaDataMap);
	}

	@GetMapping("/user/preferences/{userId}") /* Get User Preferences */
	public CarpoolResponse getUserPreferences(@PathVariable long userId) {
		log.info("This is calling get userPreferences mapping");
		Map<String, Object> dataMap = new HashMap<String, Object>();

		List<UserPreference> userPreferencesList = userPreferenceservice.getUserPreferences(userId);

		for (UserPreference userPreference : userPreferencesList) {
			if (userPreference.getPreferenceType() == 1) {
				dataMap.put("genaralPreferences", userPreference);
			} else if (userPreference.getPreferenceType() == 2) {
				dataMap.put("driverPreferences", userPreference);
			} else if (userPreference.getPreferenceType() == 3) {
				dataMap.put("passangerPreferences", userPreference);
			}

		}
		dataMap.put("userId", userId);
		
		List<UserCar> carsList = userCarService.getAllCar();
		dataMap.put("userCarDetail", carsList);

		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	private void checkForNull(UserPreference userPreferences) {
		if (null == userPreferences || null == userPreferences.getUserPreferenceId()) {
			throw new IllegalArgumentException("Please provide proper JSON for User");
		}
	}

}
