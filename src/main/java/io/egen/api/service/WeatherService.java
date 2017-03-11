package io.egen.api.service;

import java.util.List;

import io.egen.api.entity.Weather;

public interface WeatherService {

	public List<Weather> findAll();

	public Weather findOne(String city);

	public Weather create(Weather weather);

	public Weather update(String city, Weather weather);

	public void delete(String city);

	public Weather findOneTemperature(String city);
	
	public Weather findOneHumidity(String city);

	public Weather findOneWindDegree(String city);

	public Weather findOneWindSpeed(String city);

	public Weather findOneDescription(String city);

	public Weather findOnePressure(String city);
	
	public Weather findWeeklyAverage(String city);
	
	public Weather findDailyAverage(String city);

		
}