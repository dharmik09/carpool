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
import com.munifec.carpool.model.UserCar;
import com.munifec.carpool.service.UserCarService;

@RestController
@RequestMapping("/api/user-car")
public class UserCarController extends AbstractRestController implements BasicAppController<UserCar>{

	final Logger log = LoggerFactory.getLogger(UserCarController.class);

	@Autowired
	private UserCarService userCarService;
	
	public UserCarController() {
	}

	@PostMapping("/insert")
	public UserCar insert(UserCar userCar) {		
		if(null == userCar.getUserId()){
			throw new IllegalArgumentException("User id is mandatory to set user car");
		}
		//Get counter value from db for key column for Insert
		userCar.setUserCarId(getIdForNewObject(CounterConstants.USER_CAR_COUNTER));
		
		Date time = new Date(System.currentTimeMillis());
		userCar.setCreatedTime(time);
		userCar.setCreatedBy(getUserNameForLoggedInUser());
		return userCarService.saveUserCar(userCar);
	}

	@GetMapping("/view/{id}")
	public UserCar view(@PathVariable long id) {
		log.info("calling get by id UserCar mapping");
		return userCarService.getUserCarsById(id);
	}

	@GetMapping("/list")
	public List<UserCar> list() {
		log.info("This is calling get all UserCar mapping");
		return userCarService.getUserCarList();
	}

	@PostMapping("/update")
	public UserCar update(UserCar userCar) {
		log.info("calling update UserCar mapping");
		checkForNull(userCar);
		userCar.setModifiedTime(new Date());
		userCar.setModifiedBy(getUserNameForLoggedInUser());
		return userCarService.saveUserCar(userCar);
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		log.info("calling  delete by id UserCar mapping");
		userCarService.deleteUserCarById(id);
		return true;
	}	
	
	private void checkForNull(UserCar userCar) {
		if (null == userCar || null == userCar.getUserCarId()) {
			throw new IllegalArgumentException("Please provide userCarId to update a record");
		}
	}
}
