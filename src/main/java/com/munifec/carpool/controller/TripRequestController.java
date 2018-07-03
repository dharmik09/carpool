package com.munifec.carpool.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.munifec.carpool.constants.CounterConstants;
import com.munifec.carpool.constants.MessageConstants;
import com.munifec.carpool.model.TripRequest;
import com.munifec.carpool.response.CarpoolResponse;
import com.munifec.carpool.service.TripRequestService;

@RestController
@RequestMapping("/api/trip-request")
public class TripRequestController extends AbstractRestController implements BasicAppController<TripRequest> {
	
	@Autowired
	TripRequestService tripRequestService;

	@GetMapping("/list")
	public CarpoolResponse list(Pageable pageable) {
		
		List<TripRequest> requestList = tripRequestService.getAllTripRequest(pageable);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("requestList", requestList);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@PostMapping("/insert")
	public CarpoolResponse insert(TripRequest tripRequest, MultipartFile file) {
		
		long tripRequestId = getIdForNewObject(CounterConstants.TRIP_REQUEST);
		tripRequest.setTripRequestId(tripRequestId);
		tripRequest.setCreatedBy(getUserNameForLoggedInUser());
		tripRequest.setCreatedTime(new Date());
		
		tripRequest =  tripRequestService.saveRequest(tripRequest);
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("saveRequest", tripRequest);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@Override
	public CarpoolResponse update(TripRequest model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarpoolResponse delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarpoolResponse view(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
