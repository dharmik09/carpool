package com.munifec.carpool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.munifec.carpool.model.DBIDCounter;
import com.munifec.carpool.repository.CounterRepository;
import com.munifec.carpool.service.CounterService;

@Service
public class CounterServiceImpl implements CounterService{
	@Autowired
	CounterRepository counterRepository;
	
	@Override
	@Transactional
	public Long getNexId(String counterConstant) {		
		long nextId = counterRepository.findById(counterConstant).orElse(counterRepository.save(new DBIDCounter(counterConstant,1l))).getNextId();
		counterRepository.save(new DBIDCounter(counterConstant,++nextId));
		return nextId;
	}

}
