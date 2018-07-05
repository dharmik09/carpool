package com.munifec.carpool.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.munifec.carpool.constants.CommonConstants;
import com.munifec.carpool.constants.CounterConstants;
import com.munifec.carpool.constants.MessageConstants;
import com.munifec.carpool.exception.NoDataFoundException;
import com.munifec.carpool.model.DashBoard;
import com.munifec.carpool.model.Trip;
import com.munifec.carpool.model.TripRequest;
import com.munifec.carpool.model.User;
import com.munifec.carpool.model.UserPreference;
import com.munifec.carpool.model.UserRating;
import com.munifec.carpool.response.CarpoolResponse;
import com.munifec.carpool.service.DashBoardService;
import com.munifec.carpool.service.ImagesService;
import com.munifec.carpool.service.TripRequestService;
import com.munifec.carpool.service.TripService;
import com.munifec.carpool.service.UserRatingService;
import com.munifec.carpool.service.UserService;
import com.munifec.carpool.util.OTPGenerator;

@RestController
// @RequestMapping("api/user")
public class UserController extends AbstractRestController implements BasicAppController<User> {

	final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@Autowired
	ImagesService imagesService;

	@Autowired
	DashBoardService dashBoardService;

	@Autowired
	TripRequestService tripRequestService;

	@Autowired
	UserRatingService userRatingService;

	@Autowired
	TripService tripService;

	@GetMapping("/dashboard")
	public CarpoolResponse dashboard(DashBoard dashBoard) {

		dashBoard = dashBoardService.getDashboardUser(dashBoard);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("dashboard", dashBoard);

		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap);

	}

	@PostMapping("/users") // for list
	public CarpoolResponse list(Pageable pageable) {
		log.info("user to registered : ");
		List<User> listUser = userService.listAllByPage(pageable);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("users", listUser);
		Map<String, Object> page = new HashMap<String, Object>();
		page.put("page", 1);
		page.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, page);
	}

	@PostMapping("/user") // for insert
	public CarpoolResponse insert(User user, MultipartFile file) {
		log.info("user to registered : " + user);
		if (user == null) {
			throw new NoDataFoundException(MessageConstants.MSG_FAILURE_INSERT);
		}
		// Get counter value from db for key column for Insert
		long userId = getIdForNewObject(CounterConstants.USER_COUNTER);
		user.setId(userId);

		Timestamp time = new Timestamp(System.currentTimeMillis());
		user.setCreatedTime(time);
		user.setCreatedBy(getUserNameForLoggedInUser());
		User saveUser = null;
		if(file !=null) {
			saveUser = userService.saveUserWithImage(user, file);
		}else {
			saveUser = userService.saveUser(user);
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("user", saveUser);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_INSERT, dataMap, metaDataMap);

	}

	@PostMapping("/update-user") // for edit
	public CarpoolResponse update(User user) {
		log.info("user to be updated : " + user);

		
		checkForNull(user);
		userService.getUsersById(user.getId());
		user.setModifiedTime(new Date());
		user.setModifiedBy(getUserNameForLoggedInUser());
		User updatedUser = userService.saveUser(user);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("updateUser", updatedUser);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@DeleteMapping("/users/{userId}") // for delete
	public CarpoolResponse delete(@PathVariable long userId) {
		log.info("Get user by id in delete: ");
		User deleteUser = userService.getUsersById(userId);

		userService.deleteUsersById(deleteUser);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_DELETE, dataMap, metaDataMap);
	}

	@GetMapping("/view/{id}")
	public CarpoolResponse view(@PathVariable("id") long userId) {
		log.info("Get user by id in edit: ");
		User viewUser = userService.getUsersById(userId);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("user", viewUser);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@PostMapping("/update-profile")
	public CarpoolResponse updateUserProfile(User updateProfile) {

		log.info("calling userProfile mapping");
		checkForNull(updateProfile);
		String fname = updateProfile.getFirstName();
		String lname = updateProfile.getLastName();
		String pinfo = updateProfile.getPersionalInfo();
		String mobile = updateProfile.getMobile();

		// below code is to update only allowed fields only
		Long userId = updateProfile.getId();
		User updatableUser = userService.getUsersById(userId);
		updatableUser.setFirstName(fname);
		updatableUser.setLastName(lname);
		updatableUser.setPersionalInfo(pinfo);
		updatableUser.setMobile(mobile);
		updatableUser.setModifiedTime(new Date());
		updatableUser.setModifiedBy(getUserNameForLoggedInUser());
		updatableUser = userService.saveUser(updatableUser);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("userUpdateProfile", updatableUser);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@PostMapping("/update-full-profile")
	public boolean updateFullUserProfile(User user, UserPreference userPreference) {
		log.info("calling updateFullUserProfile mapping");
		checkForNull(user);
		String fname = user.getFirstName();
		String lname = user.getLastName();
		String pinfo = user.getPersionalInfo();
		String mobile = user.getMobile();
		// below code is to update only allowed fields only
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
	public ResponseEntity<Map<String, Object>> getFullUserProfile(@PathVariable("userId") long userId) {
		return new ResponseEntity<>(userService.getFullUserProfile(userId), HttpStatus.OK);
	}

	// TODO For now as we don't have SMS api, for testing purpose we are returning
	// value, else it will be void
	@PostMapping("/request-code")
	public Integer getOTP(long userId, String mobile) {
		Integer otp = OTPGenerator.generateOTP();
		// TODO Need to generate random OTP and send SMS later, when we get SMS api
		User user = userService.getUsersById(userId);
		user.setOtp(otp.toString());
		user.setOtpCreationTime(new Date());

		userService.saveUser(user);
		return otp;
	}

	@GetMapping("/get-profile-pic/{userId}")
	private ResponseEntity<Resource> downloadFile(@PathVariable Long userId, HttpServletRequest request) {
		// Load file as Resource
		// Resource resource = fileStorageService.loadFileAsResource(fileName);

		User user = userService.getUsersById(userId);
		String imageName = user.getUserImage();
		Resource resource = imagesService.downloadImage(imageName);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			log.info("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);

	}

	@PostMapping("/verify-code")
	public Boolean verifyOTP(Long userId, String otp) {
		User user = userService.getUsersById(userId);
		return otp.equals(user.getOtp());
	}

	@PostMapping("/changePassword")
	public CarpoolResponse changePassword(User user) {
		log.info("calling change password mapping");
		checkForNull(user);
		String userPass = user.getPassword();

		Long userId = user.getId();
		User updatePass = userService.getUsersById(userId);
		if (user.getEmail() != null) {
			updatePass.setPassword(userPass);
		}

		userService.saveUser(updatePass);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// dataMap.put("userEmail", userEmail);
		// dataMap.put("updatePass", updatedUser.getPassword());
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_PASSWORD, dataMap, metaDataMap);

	}

	private void checkForNull(User user) {
		if (null == user || null == user.getId()) {
			throw new IllegalArgumentException("User id is mandatory for update");
		}
	}

	/* User Ride page */
	/*
	 * /user/ride?userId=1&status=Completed/Upcoming/Cancelled&type=Driver/Passenger
	 */
	@PostMapping("/user/ride")
	private CarpoolResponse userRide(long userId, String status, String type) {
		log.info("calling the user-ride data mapping");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<TripRequest> requestList = tripRequestService.listByRequestId(userId);
		for (TripRequest tripRequest : requestList) {
			if (userId == tripRequest.getUserId())
				dataMap.put("data", requestList);
		}

		List<Trip> trips = tripService.getTripList();
		dataMap.put("tripUsers", trips);

		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);

	}

	/* User All Ride Data */
	/* /user/ride?status=Completed/Upcoming/Cancelled&type=Driver/Passenger */
	@PostMapping("/user/rides")
	public CarpoolResponse getAllRideData(String status, String type) {
		log.info("calling the get all user-ride data mapping");
		Map<String, Object> dataMap = new HashMap<String, Object>();

		List<TripRequest> requestList = tripRequestService.getAll();
		dataMap.put("data", requestList);

		List<Trip> trips = tripService.getTripList();
		dataMap.put("tripUsers", trips);

		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	/* User Given Rating Page */
	// /user/rating?userId=1&type=Given/Recieved&displayAs=Driver/Passenger
	@PostMapping("user/rating")
	private CarpoolResponse findByToUserId(long userId, String type, String displayAs) {
		log.info("calling the user-rating data mapping");
		Map<String, Object> dataMap = new HashMap<String, Object>();

		if (CommonConstants.RECEIVED.equalsIgnoreCase(type)) {
			// getReceivedRatingsFor(userId);
			List<UserRating> ratingList = userRatingService.getByFormUserRating(userId);
			for (UserRating userRating : ratingList) {
				String receive = "Received";
				dataMap.put("toFormId", userRating.getFromUserId());
				dataMap.put("name", userRating.getFromUser());
				dataMap.put("rating", userRating.getRatings());
				dataMap.put("comments", userRating.getComments());
				dataMap.put("type", receive);
			}
		} else if (CommonConstants.GIVEN.equalsIgnoreCase(type)) {
			// getGivenRatingsFor(userId);
			List<UserRating> ratingList = userRatingService.getByToUserRating(userId);
			for (UserRating userRating : ratingList) {
				String giv = "Given";
				dataMap.put("toUserId", userRating.getToUserId());
				dataMap.put("name", userRating.getToUser());
				dataMap.put("rating", userRating.getRatings());
				dataMap.put("comments", userRating.getComments());
				dataMap.put("type", giv);
			}
		}

		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	/* /user/rating?type=Given/Recieved&displayAs=Driver/Passenger */
	@PostMapping("/user/ratings")
	public CarpoolResponse getAllRating(String type, String displayAs) {
		log.info("calling the get all user-rating mapping");
		Map<String, Object> dataMap = new HashMap<String, Object>();

		List<UserRating> list = userRatingService.getAll();
		for (UserRating userRating : list) {
			
			String receive = "Received";
			dataMap.put("toFormId", userRating.getFromUserId());
			dataMap.put("name", userRating.getFromUser());
			dataMap.put("rating", userRating.getRatings());
			dataMap.put("comments", userRating.getComments());
			dataMap.put("type", receive);
			
			String giv = "Given";
			dataMap.put("toUserId", userRating.getToUserId());
			dataMap.put("name", userRating.getToUser());
			dataMap.put("rating", userRating.getRatings());
			dataMap.put("comments", userRating.getComments());
			dataMap.put("type", giv);

		}
		 
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);

	}

	/* Delete user rating */
	@DeleteMapping("/user/rating/{ratingId}")
	private CarpoolResponse deleteUserRating(@PathVariable long ratingId) {
		log.info("calling the delete-user-rating mapping");
		UserRating deleteRating = userRatingService.getRatingListById(ratingId);
		userRatingService.deleteRatating(deleteRating);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> page = new HashMap<String, Object>();
		page.put("page", 1);
		page.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_DELETE_FOR_RATING, dataMap, page);
	}
}
