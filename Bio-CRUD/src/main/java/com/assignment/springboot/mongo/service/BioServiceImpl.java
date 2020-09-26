package com.assignment.springboot.mongo.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.springboot.mongo.dao.BioDAO;
import com.assignment.springboot.mongo.exceptions.BioException;
import com.assignment.springboot.mongo.model.Bio;

@Service
public class BioServiceImpl implements BioService {

	@Autowired
	BioDAO bioDao;

	@Override
	public void addBio(Bio bio) {
		// TODO Auto-generated method stub
		if(bioDao.findById(bio.getId()).isPresent())
		{
			throw new BioException("Id already exists.");
		}
		else
			bioDao.save(bio);
	}
	
	@Override
	public Collection<Bio> getAllBios() {
		// TODO Auto-generated method stub
		return bioDao.findAll();
	}

	@Override
	public Optional<Bio> getBioById(int id) {
		// TODO Auto-generated method stub
		return bioDao.findById(id);
	}

	@Override
	public void deleteBioById(int id) {
		// TODO Auto-generated method stub
		bioDao.deleteById(id);
	}

	@Override
	public Bio updateBio(Bio bio) {
		// TODO Auto-generated method stub
		return bioDao.save(bio);
	}

	@Override
	public void deleteAllBios() {
		// TODO Auto-generated method stub
		bioDao.deleteAll();
	}

	/*
	 * @Override public Book getBookByTitle(String title) { // TODO Auto-generated
	 * method stub return bookDao.fetchByTitle(title); }
	 */

	
}