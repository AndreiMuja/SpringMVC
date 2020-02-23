package com.andrei.space.springmvc.service;

import java.util.List;

import com.andrei.space.springmvc.entity.Planet;

public interface PlanetService {
	
	public List<Planet> getPlanets();

	public void savePlanet(Planet planet);

	public List<String> getPlanetList();

	public Planet getPlanet(int planetId);

}
