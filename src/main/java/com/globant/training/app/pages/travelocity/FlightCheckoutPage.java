package com.globant.training.app.pages.travelocity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.training.app.pages.BasePage;

public class FlightCheckoutPage extends BasePage{

	private final String FLIGHT_SUMMARY = "product-summary";
	private final String FIRST_NAME_INPUT = "firstname[0]";
	private final String WHO_TRAVELS_MESSAGE = "[class='allTravelerDetails'] [class='faceoff-module-title']";
	private final String TERMS_AND_CONDITIONS_LINK = "terms-minimal-link";
	private final String COMPLETE_BOOKING_BTN = "complete-booking";
	
	
	@FindBy(className= FLIGHT_SUMMARY)
	private WebElement flightSummary;
	
	@FindBy(id= FIRST_NAME_INPUT)
	private WebElement firstNameInput;
	
	@FindBy(css= WHO_TRAVELS_MESSAGE)
	private WebElement whoTravelsMessage;
	
	@FindBy(id= TERMS_AND_CONDITIONS_LINK)
	private WebElement termsAndConditionsLink;
	
	@FindBy(id= COMPLETE_BOOKING_BTN)
	private WebElement completeBookingBtn;
	
	public FlightCheckoutPage(WebDriver pDriver) {
		super(pDriver);
		// TODO Auto-generated constructor stub
	}

	public boolean getProductSummaryPresent() {
		boolean productSummaryPresent = false;
		getWait().until(ExpectedConditions.visibilityOf(flightSummary));
		
		if(flightSummary.isDisplayed()) {
			productSummaryPresent = true;
		}
		
		return productSummaryPresent;
		
	}
	
	public boolean getFirstNameInputIsPresent() {
		boolean firstNameIsPresent = false;
		
		if(firstNameInput.isDisplayed()) {
			firstNameIsPresent = true;
		}
		
		return firstNameIsPresent;
		
	}
	
	public String getWhoTravelsMessage() {
		String whoTravelMessage = whoTravelsMessage.getText();
		return whoTravelMessage;
		
	}
	
	public boolean getTermsAndConditionsPresent() {
		boolean termsAndConditionsIsPresent = false;
		
		if(termsAndConditionsLink.isDisplayed()) {
			termsAndConditionsIsPresent = true;
		}
		return termsAndConditionsIsPresent;
		
	}
	
	public boolean getCompleteBookingBtnPresent() {
		boolean completeBookingButtonIsPresent = false;
		
		if (completeBookingBtn.isDisplayed()) {
			completeBookingButtonIsPresent = true;
		}
		
		return completeBookingButtonIsPresent;
	}
	
}
