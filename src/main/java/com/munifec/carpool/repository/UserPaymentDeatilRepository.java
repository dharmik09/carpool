package com.munifec.carpool.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.munifec.carpool.model.UserPaymentDetail;

@Repository
public interface UserPaymentDeatilRepository extends CrudRepository<UserPaymentDetail, Long>{
	public List<UserPaymentDetail> findAll(Pageable pageable);
}
