package com.swapi.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.swapi.backend.domain.Planet;

public interface PlanetService {

	public Planet findById(String id);
	
	public Page<Planet> findAll(String name, Pageable pageable);
	
	public Page<Planet> findAll(Pageable pageable);
	
	public void save(Planet planet);

	public void delete(String id);

}
