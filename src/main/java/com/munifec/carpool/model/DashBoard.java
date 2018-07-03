package com.munifec.carpool.model;

public class DashBoard {
	private Integer total_user;
	private Integer new_users_today;
	private Integer new_users_yesterday;
	private Integer new_users_last_week;
	private Integer new_users_last_month;
	private Double total_revenue_of_all_flux_rides_percentage;
	private Integer total_revenue_of_all_flux_rides_amount;
	private Integer total_commission_of_flux_all_rides_amount;
	private Integer average_price_of_all_flux_rides;
	 private Double average_price_of_all_flux_ride;
	private Double average_ride_length_of_all_flux_rides;
	private Integer average_travel_time_of_all_flux_rides;

	public DashBoard() {
		super();
	}

	public DashBoard(Integer total_user, Integer new_users_today, Integer new_users_yesterday,
			Integer new_users_last_week, Integer new_users_last_month,
			Double total_revenue_of_all_flux_rides_percentage, Integer total_revenue_of_all_flux_rides_amount,
			Integer total_commission_of_flux_all_rides_amount, Integer average_price_of_all_flux_rides,
			Double average_price_of_all_flux_ride, Double average_ride_length_of_all_flux_rides,
			Integer average_travel_time_of_all_flux_rides) {
		super();
		this.total_user = total_user;
		this.new_users_today = new_users_today;
		this.new_users_yesterday = new_users_yesterday;
		this.new_users_last_week = new_users_last_week;
		this.new_users_last_month = new_users_last_month;
		this.total_revenue_of_all_flux_rides_percentage = total_revenue_of_all_flux_rides_percentage;
		this.total_revenue_of_all_flux_rides_amount = total_revenue_of_all_flux_rides_amount;
		this.total_commission_of_flux_all_rides_amount = total_commission_of_flux_all_rides_amount;
		this.average_price_of_all_flux_rides = average_price_of_all_flux_rides;
		this.average_price_of_all_flux_ride = average_price_of_all_flux_ride;
		this.average_ride_length_of_all_flux_rides = average_ride_length_of_all_flux_rides;
		this.average_travel_time_of_all_flux_rides = average_travel_time_of_all_flux_rides;
	}

	public Integer getTotal_user() {
		return total_user;
	}

	public void setTotal_user(Integer total_user) {
		this.total_user = total_user;
	}

	public Integer getNew_users_today() {
		return new_users_today;
	}

	public void setNew_users_today(Integer new_users_today) {
		this.new_users_today = new_users_today;
	}

	public Integer getNew_users_yesterday() {
		return new_users_yesterday;
	}

	public void setNew_users_yesterday(Integer new_users_yesterday) {
		this.new_users_yesterday = new_users_yesterday;
	}

	public Integer getNew_users_last_week() {
		return new_users_last_week;
	}

	public void setNew_users_last_week(Integer new_users_last_week) {
		this.new_users_last_week = new_users_last_week;
	}

	public Integer getNew_users_last_month() {
		return new_users_last_month;
	}

	public void setNew_users_last_month(Integer new_users_last_month) {
		this.new_users_last_month = new_users_last_month;
	}

	public Double getTotal_revenue_of_all_flux_rides_percentage() {
		return total_revenue_of_all_flux_rides_percentage;
	}

	public void setTotal_revenue_of_all_flux_rides_percentage(Double total_revenue_of_all_flux_rides_percentage) {
		this.total_revenue_of_all_flux_rides_percentage = total_revenue_of_all_flux_rides_percentage;
	}

	public Integer getTotal_revenue_of_all_flux_rides_amount() {
		return total_revenue_of_all_flux_rides_amount;
	}

	public void setTotal_revenue_of_all_flux_rides_amount(Integer total_revenue_of_all_flux_rides_amount) {
		this.total_revenue_of_all_flux_rides_amount = total_revenue_of_all_flux_rides_amount;
	}

	public Integer getTotal_commission_of_flux_all_rides_amount() {
		return total_commission_of_flux_all_rides_amount;
	}

	public void setTotal_commission_of_flux_all_rides_amount(Integer total_commission_of_flux_all_rides_amount) {
		this.total_commission_of_flux_all_rides_amount = total_commission_of_flux_all_rides_amount;
	}

	public Integer getAverage_price_of_all_flux_rides() {
		return average_price_of_all_flux_rides;
	}

	public void setAverage_price_of_all_flux_rides(Integer average_price_of_all_flux_rides) {
		this.average_price_of_all_flux_rides = average_price_of_all_flux_rides;
	}

	public Double getAverage_price_of_all_flux_ride() {
		return average_price_of_all_flux_ride;
	}

	public void setAverage_price_of_all_flux_ride(Double average_price_of_all_flux_ride) {
		this.average_price_of_all_flux_ride = average_price_of_all_flux_ride;
	}

	public Double getAverage_ride_length_of_all_flux_rides() {
		return average_ride_length_of_all_flux_rides;
	}

	public void setAverage_ride_length_of_all_flux_rides(Double average_ride_length_of_all_flux_rides) {
		this.average_ride_length_of_all_flux_rides = average_ride_length_of_all_flux_rides;
	}

	public Integer getAverage_travel_time_of_all_flux_rides() {
		return average_travel_time_of_all_flux_rides;
	}

	public void setAverage_travel_time_of_all_flux_rides(Integer average_travel_time_of_all_flux_rides) {
		this.average_travel_time_of_all_flux_rides = average_travel_time_of_all_flux_rides;
	}
	
	
	
}