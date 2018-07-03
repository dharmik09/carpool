package com.munifec.carpool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.munifec.carpool.model.TripRequest;
import com.munifec.carpool.repository.TripRequestRepository;
import com.munifec.carpool.service.TripRequestService;

@Service
public class TripRequestServiceImpl implements TripRequestService {

	@Autowired
	TripRequestRepository tripRequestRepository;

	@Override
	public List<TripRequest> getAllTripRequest(Pageable pageable) {
		return tripRequestRepository.findAll(pageable);
	}

	@Override
	public TripRequest saveRequest(TripRequest tripRequest) {
		return tripRequestRepository.save(tripRequest);
	}

	@Override
	public List<TripRequest> listByRequestId(long userId) {

		return tripRequestRepository.findByUserId(userId);
	}

	@Override
	public List<TripRequest> getAll() {
		return tripRequestRepository.findAll();
	}

}
