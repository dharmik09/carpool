package com.munifec.carpool.service.impl;

import org.springframework.stereotype.Service;

import com.munifec.carpool.model.DashBoard;
import com.munifec.carpool.service.DashBoardService;

@Service
public class DashBoardServiceImpl implements DashBoardService {

	@Override
	public DashBoard getDashboardUser(DashBoard dashBoard) {
		// TODO Auto-generated method stub
		return new DashBoard(100, 5, 7, 7, 17, 25.4, 2507, 27, 7, 7.5, 7.5, 140);

	}

}
