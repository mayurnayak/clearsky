package io.egen.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api.constants.URI;
import io.egen.api.entity.Weather;
import io.egen.api.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = URI.WEATHER)
@Api(tags = "weather")
public class WeatherController {
	private WeatherService service;

	public WeatherController(WeatherService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Find All Weathers", notes = "Returns a list of Weathers in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Weather> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.CITY)
	@ApiOperation(value = "Find Weather by Id", notes = "Returns a Weather by id if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather findOne(@PathVariable("city") String city) {
		return service.findOne(city);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Create Weather", notes = "Creates a Weather in the app with unique email")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather create(@RequestBody Weather Weather) {
		return service.create(Weather);
	}

	@RequestMapping(method = RequestMethod.PUT, value = URI.CITY)
	@ApiOperation(value = "Update Weather", notes = "Updates an existing Weather")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather update(@PathVariable("city") String city, @RequestBody Weather Weather) {
		return service.update(city, Weather);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = URI.CITY)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	@ApiOperation(value = "Delete Weather", notes = "Deletes an existing Weather")
	public void delete(@PathVariable("id") String city) {
		service.delete(city);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = URI.CITY+"/temp/")
	@ApiOperation(value = "Find Weather temperature by city", notes = "Returns a Weather temperature by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather findOneTemperature(@PathVariable("city") String city) {
		return service.findOneTemperature(city);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = URI.CITY+"/humidity/")
	@ApiOperation(value = "Find Weather humidity by city", notes = "Returns a Weather temperature by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather findOneHumidit(@PathVariable("city") String city) {
		return service.findOneTemperature(city);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = URI.CITY+"/pressure/")
	@ApiOperation(value = "Find Weather pressure by city", notes = "Returns a Weather temperature by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather findOnePressure(@PathVariable("city") String city) {
		return service.findOneTemperature(city);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = URI.CITY+"/hourlyAverage/")
	@ApiOperation(value = "Find Weather hourlyAverage by city", notes = "Returns a Weather temperature by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather findHourlyAverage(@PathVariable("city") String city) {
		return service.findOneTemperature(city);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = URI.CITY+"/dailyAverage/")
	@ApiOperation(value = "Find Weather dailyAverage by city", notes = "Returns a Weather temperature by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather findDailyAverage(@PathVariable("city") String city) {
		return service.findOneTemperature(city);
	}
}
