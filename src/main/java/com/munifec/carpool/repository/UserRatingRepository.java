package com.munifec.carpool.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.munifec.carpool.model.UserRating;

@Repository
public interface UserRatingRepository extends CrudRepository<UserRating, Long>{
	public List<UserRating> findAll(Pageable pageable);
	
	@Query("SELECT toUserId,toUser,comments,ratings FROM UserRating WHERE toUserId = ?0 ALLOW FILTERING")
	public List<UserRating> findByToUser(long type);
	
	@Query("SELECT fromUserId,formUser,comments,ratings FROM UserRating where fromUserId = ?0 ALLOW FILTERING")
	public List<UserRating> findByFormUserId(long fromUserId);
	
	
	public List<UserRating> findAll();
	
	//@Query("SELECT u.userId,u.firstName,u.lastName FROM User u INNER JOIN UserRating ur ON u.userId=ur.ratingId")
	//@Param("toUserId")
}
