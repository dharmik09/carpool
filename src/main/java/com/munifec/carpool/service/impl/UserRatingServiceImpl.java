package com.munifec.carpool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.munifec.carpool.model.UserRating;
import com.munifec.carpool.repository.UserRatingRepository;
import com.munifec.carpool.service.UserRatingService;

@Service
public class UserRatingServiceImpl implements UserRatingService {

	@Autowired
	UserRatingRepository userRatingRepository;

	@Override
	public List<UserRating> getRatingList(Pageable pageable) {

		return userRatingRepository.findAll(pageable);
	}

	@Override
	public UserRating getRatingListById(long id) {

		return userRatingRepository.findById(id).get();
	}

	@Override
	public UserRating saveRating(UserRating userRating) {
		return userRatingRepository.save(userRating);
	}

	@Override
	public void deleteRatating(UserRating userRating) {
		userRatingRepository.delete(userRating);
	}

	@Override
	public List<UserRating> getByToUserRating(long toUserRating) {

		return userRatingRepository.findByToUser(toUserRating);
	}

	@Override
	public List<UserRating> getByFormUserRating(long formUserRating) {

		return userRatingRepository.findByFormUserId(formUserRating);
	}

	@Override
	public List<UserRating> getAll() {
		return userRatingRepository.findAll();
	}

}
