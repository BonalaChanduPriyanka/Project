package com.assignment.springboot.mongo.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.springboot.mongo.model.Bio;
import com.assignment.springboot.mongo.service.BioService;
@CrossOrigin
@RestController
public class BioController {

	@Autowired
	BioService service;
	
	@PostMapping(value = "/add")
	public ResponseEntity<String> addNewBio(@RequestBody Bio bio) {

		service.addBio(bio);
		return new ResponseEntity<String>("Bio created.",HttpStatus.OK);
	}


	@GetMapping(value = "/getall")
	public Collection<Bio> getAll() {

		return service.getAllBios();
	}

	
	@GetMapping(value = "/getbyid/{bio-id}")
	public Optional<Bio> getById(@PathVariable(value = "bio-id") int id) {

		return service.getBioById(id);
	}
	
	/*@GetMapping(value = "/getByTitle/{book-title}")
	public Book getByTitle(@PathVariable(value = "book-title") String title) {

		return service.getBookByTitle(title);
	}*/

	@PutMapping(value = "/update/{bio-id}")
	public String update(@PathVariable(value = "bio-id") int id, @RequestBody Bio bio) {
		bio.setId(id);
		service.updateBio(bio);
		return "Bio for id= " + id + " updated.";
	}

	@DeleteMapping(value = "/delete/{bio-id}")
	public String delete(@PathVariable(value = "bio-id") int id) {
		service.deleteBioById(id);
		return "Bio for id= " + id + " deleted.";
	}

	@DeleteMapping(value = "/deleteall")
	public String deleteAll() {
		service.deleteAllBios();
		return "All Bio records deleted.";
	}
}