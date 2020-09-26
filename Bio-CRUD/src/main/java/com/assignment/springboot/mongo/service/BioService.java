package com.assignment.springboot.mongo.service;

import java.util.Collection;
import java.util.Optional;

import com.assignment.springboot.mongo.model.Bio;

public interface BioService {

	public Collection<Bio> getAllBios();

	public Optional<Bio> getBioById(int id);

	public void deleteBioById(int id);

	public Bio updateBio(Bio bio);

	public void deleteAllBios();

	public void addBio(Bio bio);
	
	//public Book getBookByTitle(String title);
}