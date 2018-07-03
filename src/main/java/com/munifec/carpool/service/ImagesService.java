package com.munifec.carpool.service;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.munifec.carpool.images.exception.ImageStorageException;


public interface ImagesService {
	
	
	//public Images saveImage(Images images);
	
	//public List<Images> getImagesList();

	public String uploadImages(MultipartFile file, String fileId) throws ImageStorageException, IOException;
	
	 public Resource downloadImage(String fileName);

	
}
