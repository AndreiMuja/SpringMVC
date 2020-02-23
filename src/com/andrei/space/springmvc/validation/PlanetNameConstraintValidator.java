package com.andrei.space.springmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.andrei.space.springmvc.service.PlanetService;

public class PlanetNameConstraintValidator implements ConstraintValidator<UniquePlanetName, String> {

	@Autowired
	private PlanetService planetService;

	@Override
	public void initialize(UniquePlanetName uniquePlanetName) {
		
	}

	@Override
	public boolean isValid(String plName, ConstraintValidatorContext ctx) {
		return !(planetService.getPlanetList().contains(plName));
	}
	

}
