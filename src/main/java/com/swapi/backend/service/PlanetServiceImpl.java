package com.swapi.backend.service;

import java.util.Optional;

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
	public Optional<Planet> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Page<Planet> findAllByName(String name, Pageable pageable) {
		return repository.findByNameContaining(name, pageable);
	}

	@Override
	public Page<Planet> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public void save(Planet planet) {
		logger.info("Saving planet");

		repository.save(planet);

		logger.info("Planet saved");
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}
