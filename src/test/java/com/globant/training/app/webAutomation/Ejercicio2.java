package com.globant.training.app.webAutomation;

import org.testng.annotations.Test;

import com.globant.training.app.pages.travelocity.HomePage;

public class Ejercicio2 extends BaseTest{
	
	/* Exercise 2
	 * Begin the process of booking a flight with hotel and car.
	 * */
	@Test
	public void flightHotelCarBooking() {
		
		HomePage home = getHomePage();
		
		home.setFlightHotelAndCar();
		
	}

}
