package com.munifec.carpool.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.munifec.carpool.model.UserRating;

public interface UserRatingService {

	public List<UserRating> getRatingList(Pageable pageable);

	public UserRating getRatingListById(long id);
	
	public List<UserRating> getAll();

	public UserRating saveRating(UserRating userRating);

	public void deleteRatating(UserRating userRating);
	
	public List<UserRating> getByToUserRating(long toUserRating);
	
	public List<UserRating> getByFormUserRating(long formUserRating);
}
