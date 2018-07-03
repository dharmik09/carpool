package com.munifec.carpool.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.munifec.carpool.constants.CounterConstants;
import com.munifec.carpool.constants.MessageConstants;
import com.munifec.carpool.model.StaticContent;
import com.munifec.carpool.response.CarpoolResponse;
import com.munifec.carpool.service.StaticContentService;

@RestController
@RequestMapping("/api/static-content")
public class StaticContentController extends AbstractRestController implements BasicAppController<StaticContent> {
	final Logger log = LoggerFactory.getLogger(StaticContentController.class);
	@Autowired
	StaticContentService staticContentService;

	@PostMapping("/insert")
	public CarpoolResponse insert(StaticContent staticContent, MultipartFile file) {
		log.info("calling insert static-content mapping");

		// Get counter value from db for key column for Insert
		staticContent.setContentId(getIdForNewObject(CounterConstants.STATIC_CONTENT_COUNTER));

		staticContent.setCreatedBy(getUserNameForLoggedInUser());
		staticContent.setCreatedTime(new Date());
		staticContent = staticContentService.saveContent(staticContent);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("saveContent", staticContent);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@PostMapping("/update")
	public CarpoolResponse update(StaticContent staticContent) {
		log.info("calling update static-content mapping");
		checkForNull(staticContent);
		staticContent.setModifiedBy(getUserNameForLoggedInUser());
		staticContent.setModifiedTime(new Date());
		staticContent = staticContentService.saveContent(staticContent);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("updateContent", staticContent);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@DeleteMapping("/delete/{id}")
	public CarpoolResponse delete(@PathVariable long id) {
		log.info("calling delete static-content mapping");
		StaticContent content = staticContentService.getContentListById(id);

		staticContentService.deleteContent(content);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_DELETE_FOR_STATIC_CONTENT, dataMap, metaDataMap);
	}

	@GetMapping("/view/{id}")
	public CarpoolResponse view(@PathVariable long id) {
		log.info("calling view static-content mapping");
		StaticContent content = staticContentService.getContentListById(id);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("viewTrip", content);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	private void checkForNull(StaticContent staticContent) {
		if (null == staticContent || null == staticContent.getContentId()) {
			throw new IllegalArgumentException("Please provide contentId");
		}
	}

	@GetMapping("/list")
	public CarpoolResponse list(Pageable pageable) {
		log.info("calling list static-content mapping");
		List<StaticContent> contents = staticContentService.getContentList();

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("tripList", contents);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}
}
