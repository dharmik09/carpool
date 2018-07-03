package com.munifec.carpool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.munifec.carpool.model.UserPaymentDetail;
import com.munifec.carpool.repository.UserPaymentDeatilRepository;
import com.munifec.carpool.service.UserPaymentDeatilService;

@Service
public class UserPaymentDetailServiceImpl implements UserPaymentDeatilService {

	@Autowired
	UserPaymentDeatilRepository userPaymentDeatilRepository;
	
	@Override
	public UserPaymentDetail savePaymentDetail(UserPaymentDetail userPaymentDetail) {
		return userPaymentDeatilRepository.save(userPaymentDetail);
	}

	@Override
	public UserPaymentDetail getPaymentListById(long id) {
		return userPaymentDeatilRepository.findById(id).get();
	}

	@Override
	public List<UserPaymentDetail> getPaymentLists(Pageable pageable) {
		return  userPaymentDeatilRepository.findAll(pageable);
	}

	@Override
	public void deletePaymentDetail(UserPaymentDetail paymentDetail) {
			userPaymentDeatilRepository.delete(paymentDetail);
	}

	@Override
	public UserPaymentDetail updatePaymentDetail(UserPaymentDetail userPaymentDetail) {
		return null;
	}

}
