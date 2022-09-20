package com.travel.repository;

import org.springframework.data.repository.CrudRepository;

import com.travel.entity.Weather;

public interface TravelRepository extends  CrudRepository<Weather, Integer>{
	

}
