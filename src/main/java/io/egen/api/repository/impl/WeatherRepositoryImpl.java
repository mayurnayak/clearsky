package io.egen.api.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.api.entity.Weather;
import io.egen.api.repository.WeatherRepository;


@Repository
public class WeatherRepositoryImpl implements WeatherRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Weather> findAll() {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findAll", Weather.class);
		return query.getResultList();
	}

	@Override
	public Optional<Weather> findOne(String city) {
		return Optional.ofNullable(em.find(Weather.class, city));		
	}

	@Override
	public Weather create(Weather weather) {
		em.persist(weather);
		return weather;
	}

	@Override
	public Weather update(String city, Weather weather) {
		return em.merge(weather);
	}

	@Override
	public void delete(String city) {
		em.remove(em.find(Weather.class, city));		
	}

	@Override
	public Optional<Weather> findOneTemperature(String city) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findOneTemperature", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> weathers = query.getResultList();
		if (!weathers.isEmpty()) {
			return Optional.of(weathers.get(0));
		} else {
			return Optional.empty();
		}
	}
	
	
	@Override
	public Optional<Weather> findOneHumidity(String city) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findOneHumidity", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> weathers = query.getResultList();
		if (!weathers.isEmpty()) {
			return Optional.of(weathers.get(0));
		} else {
			return Optional.empty();
		}
	}
	
	@Override
	public Optional<Weather> findOnePressure(String city) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findOnePressure", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> weathers = query.getResultList();
		if (!weathers.isEmpty()) {
			return Optional.of(weathers.get(0));
		} else {
			return Optional.empty();
		}
	}
	
	@Override
	public Optional<Weather> findOneDescription(String city) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findOneDescription", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> weathers = query.getResultList();
		if (!weathers.isEmpty()) {
			return Optional.of(weathers.get(0));
		} else {
			return Optional.empty();
		}
	}
	
	@Override
	public Optional<Weather> findOneWindSpeed(String city) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findOneWindSpeed", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> weathers = query.getResultList();
		if (!weathers.isEmpty()) {
			return Optional.of(weathers.get(0));
		} else {
			return Optional.empty();
		}
	}
	
	@Override
	public Optional<Weather> findOneWindDegree(String city) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findOneWindDegree", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> weathers = query.getResultList();
		if (!weathers.isEmpty()) {
			return Optional.of(weathers.get(0));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<Weather> findHourlyAverage(String city) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findHourlyAverage", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> weathers = query.getResultList();
		if (!weathers.isEmpty()) {
			return Optional.of(weathers.get(0));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<Weather> findDailyAverage(String city) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findDailyAverage", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> weathers = query.getResultList();
		if (!weathers.isEmpty()) {
			return Optional.of(weathers.get(0));
		} else {
			return Optional.empty();
		}
	}

}
