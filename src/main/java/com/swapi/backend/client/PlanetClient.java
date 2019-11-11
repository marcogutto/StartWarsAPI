package com.swapi.backend.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.swapi.backend.exception.IncorrectNameException;

@Service
public class PlanetClient {

	@Autowired
	private GetRequestRepository request;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	public List<String> getFilms(String name) throws IncorrectNameException, Exception{
		JsonElement jsonElement = search(name);
		
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		
		JsonArray jsonArray = jsonObject.getAsJsonArray("films");
		
		List<String> films = new ArrayList<String>();
		
		jsonArray.forEach(e -> {
			films.add(e.getAsString());
		});
		
		return films;
	}
	
	public JsonElement search(String name) throws IncorrectNameException, Exception{
		JsonObject jsonObject = request.getAll("planets", name);
		
        JsonArray planets = jsonObject.getAsJsonArray("results");
		
		if(planets == null || planets.isJsonNull() || planets.size() == 0) {
			
			logger.info("Planet not saved: Planet name not found!");
			
			throw new IncorrectNameException("Planet name not found!");
		}
		
		else if(planets.size() > 1){
			
			logger.info("Planet not saved: There are more than one planet found! Please type the correct name!");
			
			throw new IncorrectNameException("There are more than one planet found! Please type the correct name!");
		}
		
		else {
			return planets.get(0);
		}
	}
	
	public boolean exists(String name) throws IncorrectNameException, Exception{
		JsonObject jsonObject = request.getAll("planets", name);
		
        JsonArray planets = jsonObject.getAsJsonArray("results");
		
		if(planets == null || planets.isJsonNull() || planets.size() == 0) {
			
			logger.info("Planet not saved: Planet name not found!");
			
			throw new IncorrectNameException("Planet name not found!");
		}
		
		else if(planets.size() > 1){
			
			logger.info("Planet not saved: There are more than one planet found! Please type the correct name!");
			
			throw new IncorrectNameException("There are more than one planet found! Please type the correct name!");
		}
		
		else {
			return true;
		}
	}
	
}
