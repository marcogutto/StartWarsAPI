package com.swapi.backend.service;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.swapi.backend.client.PlanetClient;
import com.swapi.backend.domain.Planet;
import com.swapi.backend.exception.IncorrectNameException;
import com.swapi.backend.repository.PlanetRepository;

@Service
public class PlanetServiceImpl implements PlanetService {

	@Autowired
	private PlanetRepository repository;

	@Autowired
	private PlanetClient client;

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public Optional<Planet> findById(String id) throws IncorrectNameException, Exception {

		logger.info("Begin Find planet by id");

		Optional<Planet> planet = repository.findById(id);

		if (planet.isPresent()) {
			planet.get().setFilms(client.getFilms(planet.get().getName()));
		}

		logger.info("Finish Find planet by id");

		return planet;
	}

	@Override
	public Page<Planet> findAll(Pageable pageable) throws IncorrectNameException, Exception {

		logger.info("Begin Find All planets");

		Page<Planet> planets = repository.findAll(pageable);

		for (Planet planet : planets) {
			planet.setFilms(client.getFilms(planet.getName()));
		}

		logger.info("Finish Find All planets");

		return planets;
	}

	@Override
	public void save(Planet planet) throws IncorrectNameException, Exception {
		logger.info("Saving planet");

		if (client.exists(planet.getName())) {

			repository.save(planet);

			logger.info("Planet saved");

		}

	}

	@Override
	public void delete(String id) {
		logger.info("Deleting planet ...");

		repository.deleteById(id);

		logger.info("Planet deleted");
	}

}
