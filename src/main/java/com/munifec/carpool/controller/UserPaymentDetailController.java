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
import com.munifec.carpool.model.UserPaymentDetail;
import com.munifec.carpool.response.CarpoolResponse;
import com.munifec.carpool.service.UserPaymentDeatilService;

@RestController
@RequestMapping("/api/payment-detail")
public class UserPaymentDetailController extends AbstractRestController
		implements BasicAppController<UserPaymentDetail> {

	final Logger log = LoggerFactory.getLogger(UserPaymentDetailController.class);

	@Autowired
	private UserPaymentDeatilService paymentDeatilService;

	public UserPaymentDetailController() {
		log.info("UserPaymentDeatilController");
	}

	@PostMapping("/insert")
	public CarpoolResponse insert(UserPaymentDetail userPaymentDetail, MultipartFile file) {
		log.info("insert userPaymentDetail mapping");
		// Get counter value from db for key column for Insert
		userPaymentDetail.setUserPaymentDetailId(getIdForNewObject(CounterConstants.USER_PAYMENT_DETAIL_COUNTER));
		userPaymentDetail.setCreatedBy(getUserNameForLoggedInUser());
		userPaymentDetail.setCreatedTime(new Date());
		userPaymentDetail = paymentDeatilService.savePaymentDetail(userPaymentDetail);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("saveUserPay", userPaymentDetail);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@GetMapping("/list")
	public CarpoolResponse list(Pageable pageable) {
		List<UserPaymentDetail> paymentList = paymentDeatilService.getPaymentLists(pageable);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("userPayList", paymentList);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}
	 

	@GetMapping("/view/{id}")
	public CarpoolResponse view(@PathVariable long id) {
		log.info("calling view userPaymentDetail mapping");
		 UserPaymentDetail detail =  paymentDeatilService.getPaymentListById(id);
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("viewUserPay", detail);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@DeleteMapping("/delete/{id}")
	public CarpoolResponse delete(@PathVariable long id) {
		log.info("calling delete userPaymentDetail mapping");
		UserPaymentDetail detail = paymentDeatilService.getPaymentListById(id);
		  paymentDeatilService.deletePaymentDetail(detail);
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_DELETE_FOR_USERPAYMENTDETAIL, dataMap, metaDataMap);
	}

	@PostMapping("/update")
	public CarpoolResponse update(UserPaymentDetail userPaymentDetail) {
		log.info("calling update userPaymentDetail mapping");
		checkForNull(userPaymentDetail);
		userPaymentDetail.setUpdatedBy(getUserNameForLoggedInUser());
		userPaymentDetail.setModifiedTime(new Date());
		userPaymentDetail =	paymentDeatilService.savePaymentDetail(userPaymentDetail);
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("updateUserPay", userPaymentDetail);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	private void checkForNull(UserPaymentDetail userPaymentDetail) {
		if (null == userPaymentDetail || null == userPaymentDetail.getUserPaymentDetailId()) {
			throw new IllegalArgumentException("Please provide userPaymentDetailId");
		}
	}

	

 

}
