package com.travel.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="Weather")
public class Weather {
	
	@Id
	@GeneratedValue
	private int id;

	@CreationTimestamp
	private LocalDate date;

	@JsonProperty("latitude")
	private double latitude;
	
    @JsonProperty("longitude")
	private double longitude;

	private String city;

	private String state;

	private double temperature;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public Weather(int id, LocalDate date, double latitude, double longitude, String city, String state,
			double temperature) {
		super();
		this.id = id;
		this.date = date;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.state = state;
		this.temperature = temperature;
	}

	public Weather() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Weather [id=" + id + ", date=" + date + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", city=" + city + ", state=" + state + ", temperature=" + temperature + "]";
	}

}