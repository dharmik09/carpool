package com.munifec.carpool.model;

import java.util.Date;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "userPaymentDetails")
public class UserPaymentDetail {

	@PrimaryKey
	private Long userPaymentDetailId;
	private Long userId;
	private String paymentClientType;
	private String cardLast4Digits;
	private Integer cardExpireMonth;
	private Integer cardExpireYear;
	private String createdBy;
	private Date createdTime;
	private String updatedBy;
	private Date modifiedTime;

	public UserPaymentDetail() {
		super();
	}

	public UserPaymentDetail(Long userPamentDetailId, Long userId, String paymentClientType, String cardLast4Digits,
			Integer cardExpireMonth, Integer cardExpireYear, String createdBy, Date createdTime, String updatedBy,
			Date modifiedTime) {
		super();
		this.userPaymentDetailId = userPamentDetailId;
		this.userId = userId;
		this.paymentClientType = paymentClientType;
		this.cardLast4Digits = cardLast4Digits;
		this.cardExpireMonth = cardExpireMonth;
		this.cardExpireYear = cardExpireYear;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.updatedBy = updatedBy;
		this.modifiedTime = modifiedTime;
	}

	public Long getUserPaymentDetailId() {
		return userPaymentDetailId;
	}

	public void setUserPaymentDetailId(Long userPaymentDetailId) {
		this.userPaymentDetailId = userPaymentDetailId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPaymentClientType() {
		return paymentClientType;
	}

	public void setPaymentClientType(String paymentClientType) {
		this.paymentClientType = paymentClientType;
	}

	public String getCardLast4Digits() {
		return cardLast4Digits;
	}

	public void setCardLast4Digits(String cardLast4Digits) {
		this.cardLast4Digits = cardLast4Digits;
	}

	public Integer getCardExpireMonth() {
		return cardExpireMonth;
	}

	public void setCardExpireMonth(Integer cardExpireMonth) {
		this.cardExpireMonth = cardExpireMonth;
	}

	public Integer getCardExpireYear() {
		return cardExpireYear;
	}

	public void setCardExpireYear(Integer cardExpireYear) {
		this.cardExpireYear = cardExpireYear;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "UserPaymentDetail [userPamentDetailId=" + userPaymentDetailId + ", userId=" + userId
				+ ", paymentClientType=" + paymentClientType + ", cardLast4Digits=" + cardLast4Digits
				+ ", cardExpireMonth=" + cardExpireMonth + ", cardExpireYear=" + cardExpireYear + ", createdBy="
				+ createdBy + ", createdTime=" + createdTime + ", updatedBy=" + updatedBy + ", modifiedTime="
				+ modifiedTime + "]";
	}

}
