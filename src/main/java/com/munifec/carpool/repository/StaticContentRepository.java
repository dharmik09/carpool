package com.munifec.carpool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.munifec.carpool.model.StaticContent;

@Repository
public interface StaticContentRepository extends CrudRepository<StaticContent, Long>{

}
