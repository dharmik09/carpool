package com.munifec.carpool.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface BasicAppController<E> {
	@GetMapping("/list") //GET
	public List<E> list();
	
	@PostMapping("/insert") //POST
	public E insert(E model);
	
	@PostMapping("/update") //POST
	public E update(E model);

	@DeleteMapping("/delete/{id}")  //DELETE
	public boolean delete(@PathVariable("id") long id);
	
	@GetMapping("/view/{id}") //GET
	public E view(@PathVariable("id") long id);
}
