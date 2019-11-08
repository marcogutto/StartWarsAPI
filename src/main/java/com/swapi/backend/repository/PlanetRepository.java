package com.swapi.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.swapi.backend.domain.Planet;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String> {
	
	public Page<Planet> findByNameContaining(String name, Pageable pageable);

}