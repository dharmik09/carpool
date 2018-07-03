package com.munifec.carpool.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.munifec.carpool.model.UserPaymentDetail;

public interface UserPaymentDeatilService {
	
	public UserPaymentDetail savePaymentDetail(UserPaymentDetail userPaymentDetail);
	
	public UserPaymentDetail getPaymentListById(long id);
	
	public List<UserPaymentDetail> getPaymentLists(Pageable pageable);
	
	public void deletePaymentDetail(UserPaymentDetail userPaymentDetail);
	
	public UserPaymentDetail updatePaymentDetail(UserPaymentDetail userPaymentDetail);
}
