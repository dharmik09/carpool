package com.munifec.carpool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.munifec.carpool.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
