package com.munifec.carpool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.munifec.carpool.model.UserPaymentDetail;

@Repository
public interface UserPaymentDeatilRepository extends CrudRepository<UserPaymentDetail, Long>{

}
