package com.munifec.carpool.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.munifec.carpool.model.UserPreference;

@Repository
public interface UserPreferenceRepository extends CrudRepository<UserPreference, Long>{
	@AllowFiltering
	public List<UserPreference> findByUserId(long userId);
}
