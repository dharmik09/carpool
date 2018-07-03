package com.munifec.carpool.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.munifec.carpool.constants.CounterConstants;
import com.munifec.carpool.constants.MessageConstants;
import com.munifec.carpool.model.UserRating;
import com.munifec.carpool.response.CarpoolResponse;
import com.munifec.carpool.service.UserRatingService;

@RestController
@RequestMapping("/api/rating")
public class UserRatingController extends AbstractRestController implements BasicAppController<UserRating> {

	@Autowired
	UserRatingService userRatingService;

	@GetMapping("/list")
	public CarpoolResponse list(Pageable pageable) {
		Map<String, Object> dataMap = new HashMap<String, Object>();

		List<UserRating> ratingList = userRatingService.getRatingList(pageable);
		dataMap.put("userRatingList", ratingList);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@PostMapping("/insert")
	public CarpoolResponse insert(UserRating userRating, MultipartFile file) {
		//long userId = getIdForNewObject(CounterConstants.USER_COUNTER);
		
		long ratingId = getIdForNewObject(CounterConstants.USER_RATING);
		userRating.setRatingId(ratingId);
		
		userRating.setCreatedBy(getUserNameForLoggedInUser());
		userRating.setCreatedTime(new Date());

		userRating = userRatingService.saveRating(userRating);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("saveUserRating", userRating);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@PostMapping("/update")
	public CarpoolResponse update(UserRating userRating) {

		userRating.setModifiedBy(getUserNameForLoggedInUser());
		userRating.setModifiedTime(new Date());

		userRating = userRatingService.saveRating(userRating);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("saveUserRating", userRating);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@DeleteMapping("/delete/{id}")
	public CarpoolResponse delete(@PathVariable long id) {

		UserRating deleteRating = userRatingService.getRatingListById(id);
		userRatingService.deleteRatating(deleteRating);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_DELETE_FOR_RATING, dataMap, metaDataMap);
	}

	@GetMapping("/view/{id}")
	public CarpoolResponse view(@PathVariable long id) {

		UserRating viewRating = userRatingService.getRatingListById(id);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("viewRating", viewRating);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_DELETE, dataMap, metaDataMap);
	}

}
