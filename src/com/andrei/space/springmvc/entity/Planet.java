package com.andrei.space.springmvc.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.andrei.space.springmvc.validation.DataParser;
import com.andrei.space.springmvc.validation.UniquePlanetName;

@Entity
@Table(name="planets")
public class Planet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="is required")
	@Column(name="planet_name",unique=true)
	@UniquePlanetName
	private String planetName;
	
	@NotNull(message="is required")
	@Column(name="mission")
	private String mission;
	
	@NotNull(message="is required")
	@Column(name="launch")
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@Past
	private LocalDate launch;
	
	@NotNull(message="is required")
	@Column(name="iau_pattern",unique=true)
	private String iau_code;
	
	@NotNull(message="is required")
	@Column(name="moons")
	private String moons;
	
	public Planet() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}

	public String getMission() {
		return mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}

	public LocalDate getLaunch() {
		return launch;
	}

	public void setLaunch(LocalDate launch) {
		this.launch = launch;
	}

	public String getIau_code() {
		return iau_code;
	}

	public void setIau_code(String iau_code) {
		this.iau_code = iau_code;
	}

	public String getMoons() {
		return moons;
	}

	public void setMoons(String moons) {
		this.moons = moons;
	}

	@Override
	public String toString() {
		return "Planet [id=" + id + ", planetName=" + planetName + ", mission=" + mission + ", launch=" + DataParser.formatDate(launch)
				+ ", iau_code=" + iau_code + ", moons=" + moons + "]";
	}
	
}
