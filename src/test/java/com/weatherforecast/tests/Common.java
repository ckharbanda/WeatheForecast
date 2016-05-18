package com.weatherforecast.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Common {
	public WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);	
		driver.navigate().to("https://www.my.telstra.com.au/myaccount/home");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
