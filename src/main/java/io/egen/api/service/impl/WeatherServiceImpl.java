package io.egen.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Weather;
import io.egen.api.exception.BadRequestException;
import io.egen.api.exception.NotFoundException;
import io.egen.api.repository.WeatherRepository;
import io.egen.api.service.WeatherService;

public class WeatherServiceImpl implements WeatherService{

	private WeatherRepository repository;

	public WeatherServiceImpl(WeatherRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Weather> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Weather findOne(String city) {
		return repository.findOne(city)
				.orElseThrow(() -> new NotFoundException("Weather with city " + city + " does not exist"));
	}

	@Override
	@Transactional
	public Weather create(Weather weather) {
		Optional<Weather> mayExists = repository.findOne(weather.getCity());
		if (mayExists.isPresent()) {
			throw new BadRequestException("Weather with city " + weather.getCity() + " already exists");
		}
		return repository.create(weather);
	}

	@Override
	@Transactional
	public Weather update(String city, Weather weather) {
		repository.findOne(city).orElseThrow(() -> new NotFoundException("Weather with city " + city + " does not exist"));
		return repository.update(city, weather);
	}

	@Override
	@Transactional
	public void delete(String city) {
		Weather existing = repository.findOne(city)
				.orElseThrow(() -> new NotFoundException("Weather with city " + city + " does not exist"));
		repository.delete(existing.getCity());
	}
	
	public Weather findOneTemperature(String city){
		return repository.findOneTemperature(city)
				.orElseThrow(() -> new NotFoundException("Weather with city " + city + " does not exist"));
	}

	@Override
	public Weather findOneHumidity(String city) {
		return (Weather) repository.findOneHumidity(city)
				.orElseThrow(() -> new NotFoundException("Weather with city " + city + " does not exist"));
	}

	@Override
	public Weather findOneWindDegree(String city) {
		return (Weather) repository.findOneWindDegree(city)
				.orElseThrow(() -> new NotFoundException("Weather with city " + city + " does not exist"));
	}

	@Override
	public Weather findOneWindSpeed(String city) {
		return (Weather) repository.findOneWindSpeed(city)
				.orElseThrow(() -> new NotFoundException("Weather with city " + city + " does not exist"));
	}

	@Override
	public Weather findOneDescription(String city) {
		return (Weather) repository.findOneDescription(city)
				.orElseThrow(() -> new NotFoundException("Weather with city " + city + " does not exist"));
	}

	@Override
	public Weather findOnePressure(String city) {
		return (Weather) repository.findOnePressure(city)
				.orElseThrow(() -> new NotFoundException("Weather with city " + city + " does not exist"));
	}

	@Override
	public Weather findWeeklyAverage(String city) {
		return (Weather) repository.findHourlyAverage(city)
				.orElseThrow(() -> new NotFoundException("Weather with city " + city + " does not exist"));
	}

	@Override
	public Weather findDailyAverage(String city) {
		return (Weather) repository.findDailyAverage(city)
				.orElseThrow(() -> new NotFoundException("Weather with city " + city + " does not exist"));
	}

	
}
