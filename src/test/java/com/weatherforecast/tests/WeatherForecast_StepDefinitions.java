package com.weatherforecast.tests;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weatherforecast.api.JsonReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WeatherForecast_StepDefinitions extends Common {
	private String weather_url;
	private String temperature;
	private String weatherMain;
	private String weatherDescription;
	private JSONObject jsonObject;
	
	final Logger logger = LoggerFactory.getLogger(WeatherForecast_StepDefinitions.class);
	JsonReader jsonReader = new JsonReader();
	
	@Given("^I like to holiday in \"([^\"]*)\"$")
	public void i_like_to_holiday_in(String city) throws Throwable {
		weather_url = "http://api.openweathermap.org/data/2.5/forecast/daily?q="+city+",AU&cnt=10&APPID=e7239e48c6a7afc50bd9fb2d2adae44b" + "&mode=json";
		logger.info("http query = " + weather_url);
		
		JsonReader jsonReader = new JsonReader();
		JSONObject json_response = jsonReader.readJsonFromUrl(weather_url);
		logger.info("Response = " + json_response.toString());
		Assert.assertEquals("Response is not a valid json and contains Sydney as a destination","Sydney",json_response.getJSONObject("city").getString("name"));
	}

	@And("^I only like to holiday on Thursdays$")
	public void i_only_like_to_holiday_on_Thursdays() throws Throwable {
		JSONObject json_response = jsonReader.readJsonFromUrl(weather_url);
		logger.info("Response = " + json_response.toString());

		JSONArray listArray = json_response.getJSONArray("list");
		for (int i = 0; i < listArray.length(); i++) {
		    JSONObject  jsonObject = listArray.getJSONObject(i);
		    String jsonObjectDT = jsonObject.getString("dt");
		    long batch_date = Long.parseLong(jsonObjectDT); 
		    Date dt = new Date (batch_date * 1000); 
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(dt);
			String dayOfWeek= new SimpleDateFormat("EE").format(dt);
			if (dayOfWeek.equals("Thu")){
				this.jsonObject = jsonObject;
				break;
			}
		}
	}

	@When("^I look up the weather forecast$")
	public void i_look_up_the_weather_forecast() throws Throwable {
		temperature = jsonObject.getString("deg");
		JSONArray weatherJSONArray = jsonObject.getJSONArray("weather");
		weatherMain=weatherJSONArray.getJSONObject(0).getString("main");
		weatherDescription=weatherJSONArray.getJSONObject(0).getString("description");	
		
		logger.info(temperature);
		logger.info(weatherMain);
		logger.info(weatherDescription);
	}

	@Then("^I receive the weather forecast$")
	public void i_receive_the_weather_forecast() throws Throwable {
		Assert.assertEquals("The weather was supoosed to be a clear on Thursday",weatherMain,"Clear");
		Assert.assertEquals("The weather was supoosed to be a clear sky on Thursday",weatherDescription,"clear sky");
	}

	@And("^the temperature is warmer than (\\d+) degrees$")
	public void the_temperature_is_warmer_than_degrees(int temp) throws Throwable {
		int temperatureInt = Integer.parseInt(temperature)/10;
		Assert.assertTrue("The temperature on Thursday is not greater than 10 degress", temperatureInt >10);
	}

}
