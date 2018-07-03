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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.munifec.carpool.constants.CounterConstants;
import com.munifec.carpool.constants.MessageConstants;
import com.munifec.carpool.model.Trip;
import com.munifec.carpool.response.CarpoolResponse;
import com.munifec.carpool.service.TripService;

@RestController
@RequestMapping("/api/trip")
public class TripController extends AbstractRestController implements BasicAppController<Trip> {
	final Logger log = LoggerFactory.getLogger(TripController.class);
	@Autowired
	TripService tripService;

	@GetMapping("/list")
	public CarpoolResponse list(Pageable pageable) {
		log.info("calling list trip mapping");
		List<Trip> tripList = tripService.getTripList(pageable);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("tripList", tripList);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@PostMapping("/insert")
	public CarpoolResponse insert(Trip trip, MultipartFile file) {
		log.info("calling insert trip mapping");

		// Get counter value from db for key column for Insert
		trip.setTripId(getIdForNewObject(CounterConstants.TRIP));

		trip.setCreatedBy(getUserNameForLoggedInUser());
		trip.setCreatedTime(new Date());
		trip = tripService.saveTrip(trip);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("saveTrip", trip);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_INSERT, dataMap, metaDataMap);
	}

	@PostMapping("/update")
	public CarpoolResponse update(Trip trip) {
		log.info("calling update trip mapping");
		checkForNull(trip);
		trip.setModifiedBy(getUserNameForLoggedInUser());
		trip.setModifiedTime(new Date());
		trip = tripService.saveTrip(trip);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("updateTrip", trip);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@DeleteMapping("/delete/{id}")
	public CarpoolResponse delete(@PathVariable long id) {
		log.info("calling delete trip mapping");
		Trip trip = tripService.getTripListById(id);

		tripService.deleteTrip(trip);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_DELETE, dataMap, metaDataMap);

	}

	@GetMapping("/view/{id}")
	public CarpoolResponse view(@PathVariable long id) {
		log.info("calling view trip mapping");
		Trip viewTrip= tripService.getTripListById(id);
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("viewTrip", viewTrip);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_DELETE_FOR_TRIP, dataMap,metaDataMap);
	}

	private void checkForNull(Trip trip) {
		if (null == trip || null == trip.getTripId()) {
			throw new IllegalArgumentException("Please provide tripId");
		}
	}

}
