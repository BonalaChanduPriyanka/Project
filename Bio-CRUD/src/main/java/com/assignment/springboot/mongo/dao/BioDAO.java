package com.assignment.springboot.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.assignment.springboot.mongo.model.Bio;


@Repository
public interface BioDAO extends MongoRepository<Bio, Integer> {

	//public Book fetchByTitle(String title);
}