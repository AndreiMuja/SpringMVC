package com.andrei.space.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andrei.space.springmvc.dao.PlanetDAO;
import com.andrei.space.springmvc.entity.Planet;

@Service
public class PlanetServiceImpl implements PlanetService {

	//inject planetDAO
	@Autowired
	private PlanetDAO planetDAO;
	
	@Override
	@Transactional("hibernateTx")
	public List<Planet> getPlanets() {
		return planetDAO.getPlanets();
	}

	@Override
	@Transactional("jdbcTx")
	public void savePlanet(Planet planet) {
		planetDAO.savePlanet(planet);
		
	}

	@Override
	@Transactional("hibernateTx")
	public List<String> getPlanetList() {
		return planetDAO.getPlanetNames();
	}

	@Override
	@Transactional("hibernateTx")
	public Planet getPlanet(int planetId) {
		return planetDAO.getPlanet(planetId);
	}


}
