$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/weatherforecast/resources/WeatherForecast.feature");
formatter.feature({
  "id": "this-feature-is-to-get-the-sydney-weather-forecast",
  "description": "",
  "name": "This feature is to get the sydney weather forecast",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "this-feature-is-to-get-the-sydney-weather-forecast;a-happy-holiday-maker",
  "tags": [
    {
      "name": "@weather",
      "line": 3
    }
  ],
  "description": "",
  "name": "A happy holiday maker",
  "keyword": "Scenario",
  "line": 4,
  "type": "scenario"
});
formatter.step({
  "name": "I like to holiday in \"Sydney\"",
  "keyword": "Given ",
  "line": 5
});
formatter.step({
  "name": "I only like to holiday on Thursdays",
  "keyword": "And ",
  "line": 6
});
formatter.step({
  "name": "I look up the weather forecast",
  "keyword": "When ",
  "line": 7
});
formatter.step({
  "name": "I receive the weather forecast",
  "keyword": "Then ",
  "line": 8
});
formatter.step({
  "name": "the temperature is warmer than 10 degrees",
  "keyword": "And ",
  "line": 9
});
formatter.match({
  "arguments": [
    {
      "val": "Sydney",
      "offset": 22
    }
  ],
  "location": "WeatherForecast_StepDefinitions.i_like_to_holiday_in(String)"
});
formatter.result({
  "duration": 343179943,
  "status": "pending",
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat com.weatherforecast.tests.WeatherForecast_StepDefinitions.i_like_to_holiday_in(WeatherForecast_StepDefinitions.java:20)\r\n\tat ✽.Given I like to holiday in \"Sydney\"(com/weatherforecast/resources/WeatherForecast.feature:5)\r\n"
});
formatter.match({
  "location": "WeatherForecast_StepDefinitions.i_only_like_to_holiday_on_Thursdays()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "WeatherForecast_StepDefinitions.i_look_up_the_weather_forecast()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "WeatherForecast_StepDefinitions.i_receive_the_weather_forecast()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 31
    }
  ],
  "location": "WeatherForecast_StepDefinitions.the_temperature_is_warmer_than_degrees(int)"
});
formatter.result({
  "status": "skipped"
});
});