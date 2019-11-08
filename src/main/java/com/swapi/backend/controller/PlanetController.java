package com.swapi.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swapi.backend.domain.Planet;
import com.swapi.backend.service.PlanetService;

@RestController
@RequestMapping(value = "/planets")
public class PlanetController {

	@Autowired
	private PlanetService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Planet> findById(@PathVariable("id") String id) {

		try {
			Optional<Planet> planet = service.findById(id);

			if (planet.isPresent()) {
				return new ResponseEntity<>(planet.get(), HttpStatus.NO_CONTENT);
			}

			else {
				return new ResponseEntity<>(planet.get(), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/{name}")
	public ResponseEntity<Page<Planet>> findAllByName(@PathVariable("name") String name, Pageable pageable) {

		try {
			Page<Planet> planets = null;
			planets = service.findAllByName(name, pageable);

			if (planets == null) {
				return new ResponseEntity<>(planets, HttpStatus.NO_CONTENT);
			}

			else {
				return new ResponseEntity<>(planets, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/all")
	public ResponseEntity<Page<Planet>> findAll(Pageable pageable) {

		try {
			Page<Planet> planets = null;
			planets = service.findAll(pageable);

			if (planets == null) {
				return new ResponseEntity<>(planets, HttpStatus.NO_CONTENT);
			}

			else {
				return new ResponseEntity<>(planets, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Planet planet) {
		try {
			service.save(planet);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id){
		try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
