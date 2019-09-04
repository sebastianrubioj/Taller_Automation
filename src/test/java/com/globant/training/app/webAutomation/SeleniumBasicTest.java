package com.globant.training.app.webAutomation;


//import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.testng.Assert;
import org.testng.annotations.Test;
//import java.lang.Thread;

import com.globant.training.app.pages.travelocity.FlightCheckoutPage;
import com.globant.training.app.pages.travelocity.FlightInformationPage;
import com.globant.training.app.pages.travelocity.FlightSearchPage;
import com.globant.training.app.pages.travelocity.HomePage;


public class SeleniumBasicTest extends BaseTest {
	
	
	/* Exercise 1 
	 * Begin the process of booking a flight till the complete credit card information page. 
	 * */    
	@Test(groups = {"test"})
	public void flightBooking() {
		
		HomePage home = getHomePage();
		
		String departureCity = "LAS";
		String returnCity = "LAX";
		
	/*
	 * 1. Search for a flight from LAS to LAX, 1 adult (clicking on Flight/Roundtrip). 
	 * Dates should be at least two month in the future and ​MUST​ be selected using the datepicker calendar. 
	 * */
		
		home.setFlightButton();
		home.setDepartureFlight(departureCity);
		home.setArrivalFlight(returnCity);
		home.setDepartureDate();
		home.setReturnDate();
		
		
		FlightSearchPage search = home.setSearchFlight();
		
		//Variables to indicate in what fare the element is missing 
		int buttonMissed = search.buttonMissed;
		int durationMissed = search.durationMissed;
		int fareDetailMissed = search.fareDetailMissed;
	/*
	 * 2. Verify the result page using the following: 
	 * a. There is a box that allow you to order by Price, Departure, Arrival and Duration.
	 * */
		
		Assert.assertTrue(search.getDropDownBox(),"The dropdown box is not available");
		
	/* b. The select button is present on every result */
		Assert.assertTrue(search.getselectBtnForAllFlights(),"The fare number " + buttonMissed + " does not have the select button");
		
	/* c. Flight duration is present on every result */
		Assert.assertTrue(search.getFlightDurationForAllFares(),"The fare number " + durationMissed + " does not have the time duration information");
		
	/* d. The flight detail and baggage fees is present on every result */
		Assert.assertTrue(search.getFlightDetailsForAllFares(),"The fare number " + fareDetailMissed + " does not have the Fare details link");
		
	/* 3. Sort by duration > shorter */
		search.setStoreByDuration();
		
	/* Verify the list was correctly sorted */
		Assert.assertTrue(search.getFaresOrderByDuration(), "The fares are not ordered by the Duration (shortest) as expected");
		
	/* 4. In the page (Select your departure to Los Angeles), select the first result. */ 
		search.setDepartureFlight(1);
		
	/* 5. In the new page (Select your departure to Las Vegas), select the third result. */ 
		
		FlightInformationPage information = search.setReturnFlight(3);
	
	/* Verify trip details in the new page, by: 
	 * a. Trip total price is present */
		Assert.assertTrue(information.getTotalPricePresent(), "The total price is not present on the flight information page");
		
	/* b. Departure and return information is present */
		Assert.assertTrue(information.getFlightInfoIsPresent(), "The flight information is not appearing on the information page");
		
	/* c.Price guarantee text is present */
		Assert.assertTrue(information.getFlightGuaranteeTextPresent(), "The flight guarantee text is not present on the information page");
		
	/*Press Continue Booking button. */
		
		FlightCheckoutPage checkout = information.setContinueBooking();
		
	/*Verify the “Who’s traveling” page is opened by choosing at least 5 validations to be performed. */
		Assert.assertTrue(checkout.getProductSummaryPresent(), "The product summary information is not displayed");
		Assert.assertEquals(checkout.getWhoTravelsMessage(), "Who's traveling?");
		Assert.assertTrue(checkout.getFirstNameInputIsPresent(), "The input Field to write the Name of the passenger is not pressent");
		Assert.assertTrue(checkout.getTermsAndConditionsPresent(), "The terms and conditions link is not present");
		Assert.assertTrue(checkout.getCompleteBookingBtnPresent(), "The Complete Booking Button is not present");
		
	}
	
	/* Exercise 2
	 * Begin the process of booking a flight with hotel and car.
	 * */
	
	@Test(groups = {"test2"})
	public void flightHotelCarBooking() {
		
		HomePage home = getHomePage();
		
		home.setFlightHotelAndCar();
		
		String departureCity = "LAS";
		String returnCity = "LAX";
		
		
		
		home.setDepartureFlight(departureCity);
		home.setArrivalFlight(returnCity);
		home.setDepartureDate();
		home.setReturnDate();
		
		
	}
	
}
