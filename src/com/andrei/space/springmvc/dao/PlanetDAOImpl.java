package com.andrei.space.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.jooq.DSLContext;
import org.jooq.test.tables.Planets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.andrei.space.springmvc.entity.Planet;

@Repository
public class PlanetDAOImpl implements PlanetDAO {

	// i have to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private DSLContext dsl;

	@Override
	public List<Planet> getPlanets() {

		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// create a query
		Query<Planet> query = session.createQuery("from Planet", Planet.class);

		// execute query and get result list
		List<Planet> planets = query.getResultList();

		System.out.println(planets);
		// return the results
		return planets;

	}

	@Override
	public void savePlanet(Planet planet) {

		dsl.insertInto(Planets.PLANETS, Planets.PLANETS.PLANET_NAME,Planets.PLANETS.MISSION, 
				Planets.PLANETS.LAUNCH, Planets.PLANETS.IAU_PATTERN, Planets.PLANETS.MOONS)
		   .values(planet.getPlanetName(),planet.getMission(),planet.getLaunch(),planet.getIau_code(),planet.getMoons())
		   .onDuplicateKeyIgnore()
		   .execute();
	}

	@Override
	public List<String> getPlanetNames() {
		
		Session session=sessionFactory.getCurrentSession();
		
		Query<String> names=session.createQuery("select p.planetName from Planet p",String.class);
		
		//insert the column values into a list of strings 
		List<String> pl=names.getResultList();
		
		System.out.println(pl);
		return pl;
	}

	@Override
	public Planet getPlanet(int planetId) {
		
		Session session=sessionFactory.getCurrentSession();
		
		Planet planet=session.get(Planet.class, planetId);
		
		return planet;
	}

}
