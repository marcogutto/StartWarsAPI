package com.swapi.backend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.swapi.backend.domain.Planet;

@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlanetControllerTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private String getRootUrl() {
		return "http://localhost:" + port + "/swapi";
	}

	@Test
	public void contextLoads() {

	}

	@Test
	@Order(1)
	public void testCreateANewPlanet() {
		// when
		Planet planet = new Planet();
		planet.setId("1");
		planet.setName("Mustafar");
		planet.setClimate("hot");
		planet.setTerrain("volcanoes, lava rivers, mountains, caves");
		ResponseEntity<Planet> response = restTemplate.postForEntity(getRootUrl() + "/planets/", planet, Planet.class);

		// then
		assertTrue(response.getStatusCode().equals(HttpStatus.CREATED));
	}

	@Test
	@Order(2)
	public void testGetAllPlanets() {
        // when
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/planets", HttpMethod.GET, entity,
				String.class);
		
		// then
		assertNotNull(response.getBody());
	}

	@Test
	@Order(3)
	public void testGetPlanetById() {
        // when
		
		int id = 1;
		Planet planet = restTemplate.getForObject(getRootUrl() + "/planets/" + id, Planet.class);
		
		// then
		assertNotNull(planet);
	}

	@Test
	@Order(4)
	public void testDeletePlanet() {
		
        // when
		int id = 1;
		Planet planet = restTemplate.getForObject(getRootUrl() + "/planets/" + id, Planet.class);
		
		// then
		assertNotNull(planet);
		restTemplate.delete(getRootUrl() + "/planets/" + id);
		try {
			planet = restTemplate.getForObject(getRootUrl() + "/planets/" + id, Planet.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}