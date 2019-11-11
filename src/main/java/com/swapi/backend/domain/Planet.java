package com.swapi.backend.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Planet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2001089049899957152L;

	@Id
	private String id;

	private String name;

	private String climate;

	private String terrain;
	
	@Transient
	private List<String> films;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}
	
	public int getCountFilms() {
		
		if(this.getFilms() == null) {
			return 0;
		}
		
		return this.getFilms().size();
	}

}
