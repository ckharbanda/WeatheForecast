$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/weatherforecast/resources/WeatherForecast.feature");
formatter.feature({
  "line": 1,
  "name": "This feature is to get the sydney weather forecast",
  "description": "",
  "id": "this-feature-is-to-get-the-sydney-weather-forecast",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "A happy holiday maker",
  "description": "",
  "id": "this-feature-is-to-get-the-sydney-weather-forecast;a-happy-holiday-maker",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@weather"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I like to holiday in \"Sydney\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I only like to holiday on Thursdays",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I look up the weather forecast",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I receive the weather forecast",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "the temperature is warmer than 10 degrees",
  "keyword": "And "
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
  "duration": 955227588,
  "status": "passed"
});
formatter.match({
  "location": "WeatherForecast_StepDefinitions.i_only_like_to_holiday_on_Thursdays()"
});
formatter.result({
  "duration": 279460018,
  "status": "passed"
});
formatter.match({
  "location": "WeatherForecast_StepDefinitions.i_look_up_the_weather_forecast()"
});
formatter.result({
  "duration": 330989,
  "status": "passed"
});
formatter.match({
  "location": "WeatherForecast_StepDefinitions.i_receive_the_weather_forecast()"
});
formatter.result({
  "duration": 81250,
  "status": "passed"
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
  "duration": 1863201,
  "status": "passed"
});
});