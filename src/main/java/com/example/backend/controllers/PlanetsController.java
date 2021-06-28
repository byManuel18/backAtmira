package com.example.backend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.exceptions.UnselectedPlanetException;
import com.example.backend.models.Asteroide;
import com.example.backend.models.comparators.CompareAsteroides;
import com.example.backend.services.AsteroidesService;

@RestController
@RequestMapping("/asteroids")
@CrossOrigin(origins = "*",maxAge = 3600)
public class PlanetsController {
	@Autowired
	private AsteroidesService asteroidesservice;
	@GetMapping()
	public ResponseEntity<Set<Asteroide>> getAsteroides(@RequestParam(name = "planet", defaultValue ="") String planet){
		if(planet.equals("")){
			throw new UnselectedPlanetException("Parámetro 'planet' no puede estar vacío.");
		}
	
		Set<Asteroide> listaasteroides=new TreeSet<Asteroide>(new CompareAsteroides());
		
		listaasteroides.addAll(this.asteroidesservice.getAsteroides(planet));
		
		return new ResponseEntity<Set<Asteroide>>(listaasteroides,new HttpHeaders(),HttpStatus.OK);
	}

}
