package com.munifec.carpool.model;

import java.util.Date;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value="userPreferences")

public class UserPreference {

	@PrimaryKey
	private Long userPreferenceId;
	private Long userId;
	private Integer preferenceType;
	private Integer maxDetour;
	private String maxLuggage;
	private Integer pets;
	private Integer smoke;
	private Long userCarId;
	private Integer bookingWhileDrive;
	private Integer onlyFemail;
	private Integer ratingNotification;
	private Integer chatNotification;
	private Integer rideNotification;
	private Integer paymentNotification;
	private Integer minDriverRating;
	private String createdBy;
	private Date createdTime;
	private String modifiedBy;
	private Date modifiedTime;

	public UserPreference() {
		super();
	}

	public UserPreference(Long userPreferenceId, Long userId, Integer preferenceType, Integer maxDetour,
			String maxLuggage, Integer pets, Integer smoke, Long userCarId, Integer bookingWhileDrive,
			Integer onlyFemail, Integer ratingNotification, Integer chatNotification, Integer rideNotification,
			Integer paymentNotification, Integer minDriverRating, String createdBy, Date createdTime,
			String modifiedBy, Date modifiedTime) {
		super();
		this.userPreferenceId = userPreferenceId;
		this.userId = userId;
		this.preferenceType = preferenceType;
		this.maxDetour = maxDetour;
		this.maxLuggage = maxLuggage;
		this.pets = pets;
		this.smoke = smoke;
		this.userCarId = userCarId;
		this.bookingWhileDrive = bookingWhileDrive;
		this.onlyFemail = onlyFemail;
		this.ratingNotification = ratingNotification;
		this.chatNotification = chatNotification;
		this.rideNotification = rideNotification;
		this.paymentNotification = paymentNotification;
		this.minDriverRating = minDriverRating;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.modifiedBy = modifiedBy;
		this.modifiedTime = modifiedTime;
	}

	public Long getUserPreferenceId() {
		return userPreferenceId;
	}

	public void setUserPreferenceId(Long userPreferenceId) {
		this.userPreferenceId = userPreferenceId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getPreferenceType() {
		return preferenceType;
	}

	public void setPreferenceType(Integer preferenceType) {
		this.preferenceType = preferenceType;
	}

	public Integer getMaxDetour() {
		return maxDetour;
	}

	public void setMaxDetour(Integer maxDetour) {
		this.maxDetour = maxDetour;
	}

	public String getMaxLuggage() {
		return maxLuggage;
	}

	public void setMaxLuggage(String maxLuggage) {
		this.maxLuggage = maxLuggage;
	}

	public Integer getPets() {
		return pets;
	}

	public void setPets(Integer pets) {
		this.pets = pets;
	}

	public Integer getSmoke() {
		return smoke;
	}

	public void setSmoke(Integer smoke) {
		this.smoke = smoke;
	}

	public Long getUserCarId() {
		return userCarId;
	}

	public void setUserCarId(Long userCarId) {
		this.userCarId = userCarId;
	}

	public Integer getBookingWhileDrive() {
		return bookingWhileDrive;
	}

	public void setBookingWhileDrive(Integer bookingWhileDrive) {
		this.bookingWhileDrive = bookingWhileDrive;
	}

	public Integer getOnlyFemail() {
		return onlyFemail;
	}

	public void setOnlyFemail(Integer onlyFemail) {
		this.onlyFemail = onlyFemail;
	}

	public Integer getRatingNotification() {
		return ratingNotification;
	}

	public void setRatingNotification(Integer ratingNotification) {
		this.ratingNotification = ratingNotification;
	}

	public Integer getChatNotification() {
		return chatNotification;
	}

	public void setChatNotification(Integer chatNotification) {
		this.chatNotification = chatNotification;
	}

	public Integer getRideNotification() {
		return rideNotification;
	}

	public void setRideNotification(Integer rideNotification) {
		this.rideNotification = rideNotification;
	}

	public Integer getPaymentNotification() {
		return paymentNotification;
	}

	public void setPaymentNotification(Integer paymentNotification) {
		this.paymentNotification = paymentNotification;
	}

	public Integer getMinDriverRating() {
		return minDriverRating;
	}

	public void setMinDriverRating(Integer minDriverRating) {
		this.minDriverRating = minDriverRating;
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

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "UserPreferences [userPreferenceId=" + userPreferenceId + ", userId=" + userId + ", preferenceType="
				+ preferenceType + ", maxDetour=" + maxDetour + ", maxLuggage=" + maxLuggage + ", pets=" + pets
				+ ", smoke=" + smoke + ", userCarId=" + userCarId + ", bookingWhileDrive=" + bookingWhileDrive
				+ ", onlyFemail=" + onlyFemail + ", ratingNotification=" + ratingNotification + ", chatNotification="
				+ chatNotification + ", rideNotification=" + rideNotification + ", paymentNotification="
				+ paymentNotification + ", minDriverRating=" + minDriverRating + ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime
				+ "]";
	}
	
	
}
