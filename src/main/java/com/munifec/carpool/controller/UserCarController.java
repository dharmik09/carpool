package com.munifec.carpool.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.munifec.carpool.constants.CounterConstants;
import com.munifec.carpool.constants.MessageConstants;
import com.munifec.carpool.model.UserCar;
import com.munifec.carpool.response.CarpoolResponse;
import com.munifec.carpool.service.ImagesService;
import com.munifec.carpool.service.UserCarService;

@RestController
@RequestMapping("/api/user-car")
public class UserCarController extends AbstractRestController implements BasicAppController<UserCar> {

	final Logger log = LoggerFactory.getLogger(UserCarController.class);

	@Autowired
	UserCarService userCarService;

	@Autowired
	ImagesService imagesService;

	public UserCarController() {
	}

	@PostMapping("/insert")
	public CarpoolResponse insert(UserCar userCar, MultipartFile file) {
		if (null == userCar.getUserId()) {
			throw new IllegalArgumentException("User id is mandatory to set user car");
		}
		// Get counter value from db for key column for Insert
		userCar.setUserCarId(getIdForNewObject(CounterConstants.USER_CAR_COUNTER));

		Date time = new Date(System.currentTimeMillis());
		userCar.setCreatedTime(time);
		userCar.setCreatedBy(getUserNameForLoggedInUser());

		userCar = userCarService.saveUserCarWithImage(userCar, file);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("saveUserCar", userCar);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@GetMapping("/get-car-pic/{carId}")
	private ResponseEntity<Resource> downloadFile(@PathVariable Long carId, HttpServletRequest request) {
		// Load file as Resource
		// Resource resource = fileStorageService.loadFileAsResource(fileName);

		UserCar userCar = userCarService.getUserCarsById(carId);
		String imageName = userCar.getUserCarImage();
		Resource resource = imagesService.downloadImage(imageName);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			log.info("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);

	}

	@GetMapping("/view/{id}")
	public CarpoolResponse view(@PathVariable long id) {
		log.info("calling get by id UserCar mapping");
		UserCar viewUserCar = userCarService.getUserCarsById(id);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("viewUserCar", viewUserCar);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@PostMapping("/update")
	public CarpoolResponse update(UserCar userCar) {
		log.info("calling update UserCar mapping");
		checkForNull(userCar);
		userCar.setModifiedTime(new Date());
		userCar.setModifiedBy(getUserNameForLoggedInUser());
		userCar = userCarService.saveUserCar(userCar);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("updateUserCar", userCar);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@GetMapping("/list")
	public CarpoolResponse list(Pageable pageable) {
		log.info("This is calling get all UserCar mapping");
		List<UserCar> listUserCar = userCarService.getUserCarList(pageable);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("listUserCar", listUserCar);
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_COMMON, dataMap, metaDataMap);
	}

	@DeleteMapping("/delete/{id}")
	public CarpoolResponse delete(@PathVariable long id) {
		log.info("calling  delete by id UserCar mapping");
		userCarService.deleteUserCarById(id);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put("page", 1);
		metaDataMap.put("size", 10);
		return new CarpoolResponse(1, MessageConstants.MSG_SUCCESS_DELETE_FOR_USERCAR, dataMap, metaDataMap);
	}

	private void checkForNull(UserCar userCar) {
		if (null == userCar || null == userCar.getUserCarId()) {
			throw new IllegalArgumentException("Please provide userCarId to update a record");
		}
	}

}
