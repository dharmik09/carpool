package com.munifec.carpool.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.munifec.carpool.images.exception.ImageNotFoundException;
import com.munifec.carpool.images.exception.ImageStorageException;
import com.munifec.carpool.images.property.ImagesStorageProperties;
import com.munifec.carpool.repository.ImagesRepository;
import com.munifec.carpool.service.ImagesService;

@Service
public class ImagesServiceImpl implements ImagesService {

	private Path imageStorageLocation = null;

	@Autowired
	ImagesRepository imagesRepository;

	@Autowired
	public ImagesServiceImpl(ImagesStorageProperties imagesStorageProperties) {
		this.imageStorageLocation = Paths.get(imagesStorageProperties.getUploadDir()).toAbsolutePath().normalize();

		try {
			Files.createDirectories(this.imageStorageLocation);
		} catch (Exception ex) {
			throw new ImageStorageException("Could not create the directory where the uploaded files will be stored.",
					ex);
		}
	}

	public String uploadImages(MultipartFile file, String fileId) throws IOException {
		// Normalize file name
		InputStream in = null;

		try {
			in = file.getInputStream();
			// Check if the file's name contains invalid characters

			String image = StringUtils.cleanPath(file.getOriginalFilename());
			if (image.contains("..")) {
				throw new ImageStorageException("Sorry! Filename contains invalid path sequence " + image);
			}

			String imageName = getImageNameWithExtension(image, fileId);

			// Copy file to the target location (Replacing existing file with the id of
			// Entity object)
			Path targetLocation = this.imageStorageLocation.resolve(imageName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			return imageName;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String getImageNameWithExtension(String fileName, String fileId) {
		if (null != fileName) {
			String extension = fileName.substring(fileName.indexOf('.') + 1, fileName.length());
			System.out.println("File extension :" + extension);

			fileId = fileId + "." + extension;
		}
		return fileId;
	}

	@Override
	public Resource downloadImage(String imageName) {
		try {
			Path filePath = this.imageStorageLocation.resolve(imageName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new ImageNotFoundException("File not found " + imageName);
			}
		} catch (MalformedURLException ex) {
			throw new ImageNotFoundException("File not found " + imageName, ex);
		}
	}

}
