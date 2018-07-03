package com.munifec.carpool.model;

import java.util.Date;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("trip")
public class Trip {
	@PrimaryKey
	private Long tripId;
	private Long userId;
	private Integer seats;
	private String startLocationText;
	private String endLocationText;
	private Long startLocationLatitute;
	private Long startLocationLongitute;
	private Long endLocationLatitite;
	private Long endLocationLongitute;
	private String instantly;
	private Date tripStartTime;
	private Long parentTripId;
	private Integer tripStatus;
	private Long estimatedTripDistance;
	private Date estimatedTripTime; // change Date To Long
	private Long actualTripDistance; 
	private Date actualTripEndTime;  // change Date To Long
	private Double tripEarning;
	private String createdBy;
	private Date createdTime;
	private String modifiedBy;
	private Date modifiedTime;
	public Long getTripId() {
		return tripId;
	}
	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	public String getStartLocationText() {
		return startLocationText;
	}
	public void setStartLocationText(String startLocationText) {
		this.startLocationText = startLocationText;
	}
	public String getEndLocationText() {
		return endLocationText;
	}
	public void setEndLocationText(String endLocationText) {
		this.endLocationText = endLocationText;
	}
	public Long getStartLocationLatitute() {
		return startLocationLatitute;
	}
	public void setStartLocationLatitute(Long startLocationLatitute) {
		this.startLocationLatitute = startLocationLatitute;
	}
	public Long getStartLocationLongitute() {
		return startLocationLongitute;
	}
	public void setStartLocationLongitute(Long startLocationLongitute) {
		this.startLocationLongitute = startLocationLongitute;
	}
	public Long getEndLocationLatitite() {
		return endLocationLatitite;
	}
	public void setEndLocationLatitite(Long endLocationLatitite) {
		this.endLocationLatitite = endLocationLatitite;
	}
	public Long getEndLocationLongitute() {
		return endLocationLongitute;
	}
	public void setEndLocationLongitute(Long endLocationLongitute) {
		this.endLocationLongitute = endLocationLongitute;
	}
	public String getInstantly() {
		return instantly;
	}
	public void setInstantly(String instantly) {
		this.instantly = instantly;
	}
	public Date getTripStartTime() {
		return tripStartTime;
	}
	public void setTripStartTime(Date tripStartTime) {
		this.tripStartTime = tripStartTime;
	}
	public Long getParentTripId() {
		return parentTripId;
	}
	public void setParentTripId(Long parentTripId) {
		this.parentTripId = parentTripId;
	}
	public Integer getTripStatus() {
		return tripStatus;
	}
	public void setTripStatus(Integer tripStatus) {
		this.tripStatus = tripStatus;
	}
	public Long getEstimatedTripDistance() {
		return estimatedTripDistance;
	}
	public void setEstimatedTripDistance(Long estimatedTripDistance) {
		this.estimatedTripDistance = estimatedTripDistance;
	}
	public Date getEstimatedTripTime() {
		return estimatedTripTime;
	}
	public void setEstimatedTripTime(Date estimatedTripTime) {
		this.estimatedTripTime = estimatedTripTime;
	}
	public Long getActualTripDistance() {
		return actualTripDistance;
	}
	public void setActualTripDistance(Long actualTripDistance) {
		this.actualTripDistance = actualTripDistance;
	}
	public Date getActualTripEndTime() {
		return actualTripEndTime;
	}
	public void setActualTripEndTime(Date actualTripEndTime) {
		this.actualTripEndTime = actualTripEndTime;
	}
	public Double getTripEarning() {
		return tripEarning;
	}
	public void setTripEarning(Double tripEarning) {
		this.tripEarning = tripEarning;
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
	 

	
}
