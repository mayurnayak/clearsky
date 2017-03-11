package io.egen.api.repository;

import java.util.List;
import java.util.Optional;

import io.egen.api.entity.Weather;

public interface WeatherRepository {
	public List<Weather> findAll();

	public Optional<Weather> findOne(String city);

	public  Weather create(Weather weather);

	public Weather update(String city, Weather weather);

	public void delete(String city);

	public Optional<Weather> findOneTemperature(String city);

	public Optional<Weather> findOneHumidity(String city);

	public Optional<Weather> findOneWindDegree(String city);

	public Optional<Weather> findOneWindSpeed(String city);

	public Optional<Weather> findOneDescription(String city);

	public Optional<Weather> findOnePressure(String city);
	
	public Optional<Weather> findHourlyAverage(String city);
	
	public Optional<Weather> findDailyAverage(String city);
}
