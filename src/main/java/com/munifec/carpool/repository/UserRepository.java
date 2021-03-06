package com.munifec.carpool.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.munifec.carpool.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	 	
	public List<User> findAll(Pageable pageable);
	
	//public Page<User> getPage(CassandraPageRequest pageRequest);
}
