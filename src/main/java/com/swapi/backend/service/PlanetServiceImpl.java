package com.swapi.backend.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.swapi.backend.domain.Planet;
import com.swapi.backend.repository.PlanetRepository;

@Service
public class PlanetServiceImpl implements PlanetService {

	@Autowired
	private PlanetRepository repository;

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public Planet findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Planet> findAll(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Planet> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Planet planet) {
		// TODO Auto-generated method stub
		logger.info("Saving planet");

		repository.save(planet);

		logger.info("Planet saved");
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}
