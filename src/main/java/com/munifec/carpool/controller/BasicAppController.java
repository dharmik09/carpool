package com.munifec.carpool.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.munifec.carpool.response.CarpoolResponse;

public interface BasicAppController<E> {
	 
	public CarpoolResponse list(Pageable pageable);
	
	 
	public CarpoolResponse insert(E model,MultipartFile file);
	
	 
	public CarpoolResponse update(E model);

	//@DeleteMapping("/delete/{id}")  //DELETE
	public CarpoolResponse delete(@PathVariable("id") long id);
	
	//@GetMapping("/view/{id}") //GET
	public CarpoolResponse view(@PathVariable("id") long id);
}
