package com.swapi.backend.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.swapi.backend.domain.Planet;

public interface PlanetService {

	public Optional<Planet> findById(String id);
	
	public Page<Planet> findAllByName(String name, Pageable pageable);
	
	public Page<Planet> findAll(Pageable pageable);
	
	public void save(Planet planet);

	public void delete(String id);

}
