package com.munifec.carpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.munifec.carpool.images.property.ImagesStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	ImagesStorageProperties.class
})
public class CarPoolServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarPoolServiceApplication.class, args);
	}
}
