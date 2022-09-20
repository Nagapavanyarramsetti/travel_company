package com.travel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.entity.Weather;
import com.travel.repository.TravelRepository;

@Service
public class TravelService {
	@Autowired
	TravelRepository travelRepository;
	
	public List<Weather> getDetails() {
		return travelRepository.findAll();
	}
	public Weather save(Weather weather) {
		return travelRepository.save(weather);
	}
	public void deleteById(int id) {
		travelRepository.deleteById(id);
	}
	public Optional<Weather> retrieveById(int id) {
		return travelRepository.findById(id);
	}
	

}
