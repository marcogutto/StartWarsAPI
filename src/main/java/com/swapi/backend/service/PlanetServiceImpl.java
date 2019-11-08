package com.swapi.backend.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapi.backend.domain.Planet;
import com.swapi.backend.repository.PlanetRepository;

@Service
public class PlanetServiceImpl implements PlanetService {

	@Autowired
	private PlanetRepository repository;

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public void save(Planet planet) {
		// TODO Auto-generated method stub
		logger.info("Saving planet");

		repository.save(planet);

		logger.info("Planet saved");
	}

}
