package com.swapi.backend.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.swapi.backend.domain.Planet;
import com.swapi.backend.exception.IncorrectNameException;

public interface PlanetService {

	public Optional<Planet> findById(String id) throws IncorrectNameException, Exception;
	
	public Page<Planet> findAll(Pageable pageable) throws IncorrectNameException, Exception;
	
	public void save(Planet planet) throws IncorrectNameException, Exception;

	public void delete(String id);

}
