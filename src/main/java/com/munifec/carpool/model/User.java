package com.munifec.carpool.model;


import java.util.Date;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table( value = "Users")
public class User {
	@PrimaryKey
	private Long id;
	private String email;
	private String password;
	private Date dobTime;
	private String gender;
	private String firstName;
	private String lastName;
	private Integer clientType;
	private String accessToken;
	private String refereshToken;
	private String socialNetworkId;
	private Long roleId;
	private String mobile;
	private String otp;
	private Date otpCreationTime;
	private String createdBy;
	private Date createdTime;
	private String modifiedBy;
	private Date modifiedTime;
	private String imageId;
	private String persionalInfo;
	
	
	/**
	 * @return the otpCreationTime
	 */
	public Date getOtpCreationTime() {
		return otpCreationTime;
	}
	/**
	 * @param otpCreationTime the otpCreationTime to set
	 */
	public void setOtpCreationTime(Date otpCreationTime) {
		this.otpCreationTime = otpCreationTime;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the dobTime
	 */
	public Date getDobTime() {
		return dobTime;
	}
	/**
	 * @param dobTime the dobTime to set
	 */
	public void setDobTime(Date dobTime) {
		this.dobTime = dobTime;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the clientType
	 */
	public Integer getClientType() {
		return clientType;
	}
	/**
	 * @param clientType the clientType to set
	 */
	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}
	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	/**
	 * @return the refereshToken
	 */
	public String getRefereshToken() {
		return refereshToken;
	}
	/**
	 * @param refereshToken the refereshToken to set
	 */
	public void setRefereshToken(String refereshToken) {
		this.refereshToken = refereshToken;
	}
	/**
	 * @return the socialNetworkId
	 */
	public String getSocialNetworkId() {
		return socialNetworkId;
	}
	/**
	 * @param socialNetworkId the socialNetworkId to set
	 */
	public void setSocialNetworkId(String socialNetworkId) {
		this.socialNetworkId = socialNetworkId;
	}
	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the otp
	 */
	public String getOtp() {
		return otp;
	}
	/**
	 * @param otp the otp to set
	 */
	public void setOtp(String otp) {
		this.otp = otp;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the createdTime
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}
	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	/**
	 * @return the modifiedTime
	 */
	public Date getModifiedTime() {
		return modifiedTime;
	}
	/**
	 * @param modifiedTime the modifiedTime to set
	 */
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	/**
	 * @return the imageId
	 */
	public String getImageId() {
		return imageId;
	}
	/**
	 * @param imageId the imageId to set
	 */
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	/**
	 * @return the persionalInfo
	 */
	public String getPersionalInfo() {
		return persionalInfo;
	}
	/**
	 * @param persionalInfo the persionalInfo to set
	 */
	public void setPersionalInfo(String persionalInfo) {
		this.persionalInfo = persionalInfo;
	}
	
	
	 
	 
	 
}
