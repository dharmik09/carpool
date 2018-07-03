package com.munifec.carpool.service;

import java.util.List;

import com.munifec.carpool.model.StaticContent;

public interface StaticContentService {

	public List<StaticContent> getContentList();

	public StaticContent getContentListById(long id);

	public StaticContent saveContent(StaticContent staticContent);

	public void deleteContent(StaticContent staticContent);
	
}
