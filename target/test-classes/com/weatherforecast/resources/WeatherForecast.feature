Feature: This feature is to get the sydney weather forecast
	
  @weather
  Scenario: A happy holiday maker
      Given I like to holiday in "Sydney"
      And I only like to holiday on Thursdays
      When I look up the weather forecast
      Then I receive the weather forecast
      And the temperature is warmer than 10 degrees