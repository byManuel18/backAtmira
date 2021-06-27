package com.example.backend.controllers;

import java.util.ArrayList;
import java.util.List;

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
import com.example.backend.services.AsteroidesService;

@RestController
@RequestMapping("/asteroids")
@CrossOrigin(origins = "*",maxAge = 3600)
public class PlanetsController {
	@Autowired
	private AsteroidesService asteroidesservice;
	@GetMapping()
	public ResponseEntity<List<Asteroide>> getAsteroides(@RequestParam(name = "planet", defaultValue ="") String planet){
		if(planet.equals("")){
			throw new UnselectedPlanetException("Parámetro 'planet' no puede estar vacío.");
		}
		
		this.asteroidesservice.getAlgo();
		List<Asteroide> listaasteroides=new ArrayList<Asteroide>();
		
		return new ResponseEntity<List<Asteroide>>(listaasteroides,new HttpHeaders(),HttpStatus.OK);
	}

}
