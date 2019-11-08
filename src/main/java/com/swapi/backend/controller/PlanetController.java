package com.swapi.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swapi.backend.domain.Planet;
import com.swapi.backend.service.PlanetService;

@RestController
@RequestMapping(value = "/swapi")
public class PlanetController {

	@Autowired
	private PlanetService service;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Planet planet) {
		try {
			service.save(planet);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
