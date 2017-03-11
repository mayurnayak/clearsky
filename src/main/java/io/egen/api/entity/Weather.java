package io.egen.api.entity;

import java.sql.Timestamp;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author mayurnayak
 * "city": "Chicago",
  "description": "scattered clouds",
  "humidity": 33,
  "pressure": 1020,
  "temperature": 25,
  "wind": {
    "speed": 3.1,
    "degree": 240
  },
  "timestamp": "2017-02-14T05:48:41.861Z"
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name="Weather.findAll", query="SELECT w FROM Weather w ORDER BY w.city"),
	@NamedQuery(name="Weather.findOneTemperature", query="SELECT temperature FROM Weather w where w.city=:pCity"),
	@NamedQuery(name="Weather.findOneHumidity", query="SELECT humidity FROM Weather w where w.city=:pCity"),
	@NamedQuery(name="Weather.findOnePressure", query="SELECT pressure FROM Weather w where w.city=:pCity"),
	@NamedQuery(name="Weather.findOneDescription", query="SELECT description FROM Weather w where w.city=:pCity"),
	@NamedQuery(name="Weather.findOneWindSpeed", query="SELECT wind.speed FROM Weather w where w.city=:pCity"),
	@NamedQuery(name="Weather.findDailyAverage", query="Select CAST(time as date), AVG(humidity), avg(pressure), AVG(temperature),AVG(wind.speed), AVG(wind.degree) From Weather w where w.city:= pCity Group By CAST(time as date)"),
	@NamedQuery(name="Weather.findOneWindDegree", query="SELECT wind.degree FROM Weather w where w.city=:pCity"),
	@NamedQuery(name="Weather.findHourlyAverage", query="SELECT CAST(FLOOR(CAST(time AS float)) AS datetime) AS day --strip time, DATEPART(hh, time) AS hour, AVG(temperature),AVG(wind.speed), AVG(wind.degree) FROM Weather w where w.city := pCity GROUP BY    CAST(FLOOR(CAST(time AS float)) AS datetime), DATEPART(hh, time)")
	/*
	/*
	 * 
	 * */
	

})
public class Weather {
	@Id
	private String city;
	private String description;
	private Integer humidity;
	private Integer pressure;
	private Integer temperature;
	@Embedded
	private Wind wind;
	private Timestamp time;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	public Integer getPressure() {
		return pressure;
	}
	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}
	public Integer getTemperature() {
		return temperature;
	}
	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
