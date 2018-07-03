package com.munifec.carpool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.munifec.carpool.model.StaticContent;
import com.munifec.carpool.repository.StaticContentRepository;
import com.munifec.carpool.service.StaticContentService;

@Service
public class StaticContentServiceImpl implements StaticContentService {

	@Autowired
	StaticContentRepository staticContentRepository;

	@Override
	public List<StaticContent> getContentList() {
		return (List<StaticContent>) staticContentRepository.findAll();
	}

	@Override
	public StaticContent saveContent(StaticContent staticContent) {
		return staticContentRepository.save(staticContent);
	}

	@Override
	public void deleteContent(StaticContent staticContent) {
		staticContentRepository.delete(staticContent);
	}

	@Override
	public StaticContent getContentListById(long id) {
		return staticContentRepository.findById(id).get();
	}

	 

}
