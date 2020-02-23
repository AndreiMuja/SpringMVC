package com.andrei.space.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.andrei.space.springmvc.entity.Planet;
import com.andrei.space.springmvc.service.PlanetService;

@Controller
@RequestMapping("/planet")
public class PlanetController {

	// inject planetService which injected Planet DAO - scan component that implements these interfaces
	@Autowired
	private PlanetService planetService;
	
	@InitBinder
	public void initBinder(WebDataBinder result) {
		StringTrimmerEditor ste=new StringTrimmerEditor(true);
		result.registerCustomEditor(String.class, ste);
	}
	
	// starting with Spring 4.3, you can replace @RequestMapping(...) with
	// GetMapping("/path") or PostMapping for GET and POST requests
	@RequestMapping(value = "/listPlanets", method = RequestMethod.GET)
	public String listOfPlanets(Model model) {

		// get planets from the planet service who uses dao
		List<Planet> planets = planetService.getPlanets();

		// add planets to the model - this name will be used to bind with the jsp form
		model.addAttribute("planets", planets);

		return "list-planets";
	}

	@GetMapping("/addForm")
	public String showAddForm(Model model) {
		Planet planet = new Planet();
		model.addAttribute("planet", planet);
		return "planet-form";
	}

	@PostMapping("/savePlanet")
	public String savePlanet(@Valid @ModelAttribute("planet") Planet planet, BindingResult bindResult) {

		if (bindResult.hasErrors()) {
			return "planet-form";
		} else {
			// save planet using our service
			planetService.savePlanet(planet);
			return "redirect:/planet/listPlanets";
		}
	}
	
	@GetMapping("/updatePlanetForm")
	public String updatePlanetForm(@RequestParam("planetId") int planetId, Model model) {
		
		Planet planet = planetService.getPlanet(planetId);
		
		//model attribute to populate the form
		model.addAttribute("planet",planet);
		
		return "planetUpdate-form";
		
	}

}
