package com.munifec.carpool.model;

import java.util.Date;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "tripRequest")
public class TripRequest {

	@PrimaryKey
	private Long tripRequestId;
	private Long tripId;
	private Long userId;
	private Date estimatedTripTime;
	private Date estimatedTripDistance;
	private Long actualTripDistance;
	private Date actualTripEndTime;
	private Integer tripRequestStatus;
	private String startLocationText;
	private String endLocationText;
	private Long startLocationLatitute;
	private Long startLocationLongitute;
	private Long endLocationLatitite;
	private Long endLocationLongitute;
	private Integer seats;
	private Integer estimatedTripCost;
	private Integer actualTripCost;
	private String createdBy;
	private Date createdTime;
	private String modifiedBy;
	private Date modifiedTime;

	public Long getTripRequestId() {
		return tripRequestId;
	}

	public void setTripRequestId(Long tripRequestId) {
		this.tripRequestId = tripRequestId;
	}

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

	public Date getEstimatedTripTime() {
		return estimatedTripTime;
	}

	public void setEstimatedTripTime(Date estimatedTripTime) {
		this.estimatedTripTime = estimatedTripTime;
	}

	public Date getEstimatedTripDistance() {
		return estimatedTripDistance;
	}

	public void setEstimatedTripDistance(Date estimatedTripDistance) {
		this.estimatedTripDistance = estimatedTripDistance;
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

	public Integer getTripRequestStatus() {
		return tripRequestStatus;
	}

	public void setTripRequestStatus(Integer tripRequestStatus) {
		this.tripRequestStatus = tripRequestStatus;
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

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public Integer getEstimatedTripCost() {
		return estimatedTripCost;
	}

	public void setEstimatedTripCost(Integer estimatedTripCost) {
		this.estimatedTripCost = estimatedTripCost;
	}

	public Integer getActualTripCost() {
		return actualTripCost;
	}

	public void setActualTripCost(Integer actualTripCost) {
		this.actualTripCost = actualTripCost;
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
