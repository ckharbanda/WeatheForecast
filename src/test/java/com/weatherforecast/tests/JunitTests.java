package com.weatherforecast.tests;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weatherforecast.api.JsonReader;

public class JunitTests {
	final Logger logger = LoggerFactory.getLogger(WeatherForecast_StepDefinitions.class);
	private JSONObject jsonObject;
	@Test
	public void test() throws IOException, JSONException{
		String weather_url = "http://api.openweathermap.org/data/2.5/forecast/daily?q=Sydney,AU&cnt=10&APPID=e7239e48c6a7afc50bd9fb2d2adae44b";
		logger.info("http query = " + weather_url);
		System.out.println(weather_url);
		
		JsonReader jsonReader = new JsonReader();
		JSONObject json_response = jsonReader.readJsonFromUrl(weather_url);
		logger.info("Response = " + json_response.toString());
		
		String sydney = json_response.getJSONObject("city").getString("name");
		System.out.println(sydney);
		
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
		
		JSONArray weatherJSONArray = jsonObject.getJSONArray("weather");
		weatherJSONArray.getJSONObject(0).getString("main");
		weatherJSONArray.getJSONObject(0).getString("description");
			
		}
		
}



