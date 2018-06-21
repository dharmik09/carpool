package com.munifec.carpool.service;

import java.util.List;

import com.munifec.carpool.model.UserPaymentDetail;

public interface UserPaymentDeatilService {
	
	public UserPaymentDetail savePaymentDetail(UserPaymentDetail userPaymentDetail);
	
	public UserPaymentDetail getPaymentListById(long id);
	
	public List<UserPaymentDetail> getPaymentLists();
	
	public void deletePaymentDetail(UserPaymentDetail userPaymentDetail);
	
	public UserPaymentDetail updatePaymentDetail(UserPaymentDetail userPaymentDetail);
}
