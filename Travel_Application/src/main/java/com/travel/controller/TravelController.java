package com.travel.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entity.Weather;
import com.travel.service.TravelService;

@RestController
public class TravelController {
	
	@Autowired
	TravelService travelService;
	Logger logger;
	
	@RequestMapping(value="/weather", method=RequestMethod.GET)
	public List<Weather> retrieveAllDetails() {
		return travelService.getDetails();
	}

	@RequestMapping(value="/weather/{id}", method=RequestMethod.GET)
	public Object retrieveSpecificDetails(@PathVariable int id) {
		Optional<Weather> weather=travelService.retrieveById(id);
		if (weather.isPresent())
			return weather.get();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@RequestMapping(value="/weather", method=RequestMethod.POST)
	public ResponseEntity<?> postDetails(@RequestBody Weather weather) {
		weather = travelService.save(weather);
		return ResponseEntity.status(HttpStatus.CREATED).body(weather);
	}

	@RequestMapping(value="/weather/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteDetails(@PathVariable int id) {
		Optional<Weather> weather = travelService.retrieveById(id);
		if (weather.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		travelService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
