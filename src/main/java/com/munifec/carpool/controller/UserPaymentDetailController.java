package com.munifec.carpool.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.munifec.carpool.constants.CounterConstants;
import com.munifec.carpool.model.UserPaymentDetail;
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
	public UserPaymentDetail insert(UserPaymentDetail userPaymentDetail) {
		log.info("insert userPaymentDetail mapping");
		//Get counter value from db for key column for Insert
		userPaymentDetail.setUserPaymentDetailId(getIdForNewObject(CounterConstants.USER_PAYMENT_DETAIL_COUNTER));
		userPaymentDetail.setCreatedBy(getUserNameForLoggedInUser());
		userPaymentDetail.setCreatedTime(new Date());
		return paymentDeatilService.savePaymentDetail(userPaymentDetail);
	}

	@GetMapping("/list")
	public List<UserPaymentDetail> list() {
		log.info("calling list userPaymentDetail mapping");
		return paymentDeatilService.getPaymentLists();
	}

	@GetMapping("/view/{id}")
	public UserPaymentDetail view(@PathVariable long id) {
		log.info("calling view userPaymentDetail mapping");
		return paymentDeatilService.getPaymentListById(id);
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		log.info("calling delete userPaymentDetail mapping");
		UserPaymentDetail detail = paymentDeatilService.getPaymentListById(id);
		boolean isDeleted = false;
		if (detail != null) {
			paymentDeatilService.deletePaymentDetail(detail);
			isDeleted = true;
		}
		return isDeleted;
	}

	@PostMapping("/update")
	public UserPaymentDetail update(UserPaymentDetail userPaymentDetail) {
		log.info("calling update userPaymentDetail mapping");
		checkForNull(userPaymentDetail);
		userPaymentDetail.setUpdatedBy(getUserNameForLoggedInUser());
		userPaymentDetail.setModifiedTime(new Date());
		return paymentDeatilService.savePaymentDetail(userPaymentDetail);
	}

	private void checkForNull(UserPaymentDetail userPaymentDetail) {
		if (null == userPaymentDetail || null == userPaymentDetail.getUserPaymentDetailId()) {
			throw new IllegalArgumentException("Please provide userPaymentDetailId");
		}
	}

}
