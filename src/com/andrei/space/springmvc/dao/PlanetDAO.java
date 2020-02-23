package com.andrei.space.springmvc.dao;

import java.util.List;

import com.andrei.space.springmvc.entity.Planet;

public interface PlanetDAO {
	
	public List<Planet> getPlanets();

	public void savePlanet(Planet planet);

	public List<String> getPlanetNames();

	public Planet getPlanet(int planetId);

}
