package com.globant.training.app.pages.travelocity;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.training.app.pages.BasePage;

public class FlightCheckoutPage extends BasePage{

	private final String FLIGHT_SUMMARY = "product-summary";
	private final String FIRST_NAME_INPUT = "firstname[0]";
	private final String WHO_TRAVELS_MESSAGE = "[class='allTravelerDetails'] [class='faceoff-module-title']";
	private final String TERMS_AND_CONDITIONS_LINK = "terms-minimal-link";
	private final String COMPLETE_BOOKING_BTN = "complete-booking";
	private final String PRODUCTS_SELECTED_LIST = "product-content-title";	
	
	@FindAll({@FindBy(className= FLIGHT_SUMMARY)})
	private List<WebElement> flightSummary;
	
	@FindBy(id= FIRST_NAME_INPUT)
	private WebElement firstNameInput;
	
	@FindBy(css= WHO_TRAVELS_MESSAGE)
	private WebElement whoTravelsMessage;
	
	@FindBy(id= TERMS_AND_CONDITIONS_LINK)
	private WebElement termsAndConditionsLink;
	
	@FindBy(id= COMPLETE_BOOKING_BTN)
	private WebElement completeBookingBtn;
	
	@FindAll({@FindBy(className= PRODUCTS_SELECTED_LIST)})
	private List<WebElement> productSelectedList;
	
	public FlightCheckoutPage(WebDriver pDriver) {
		super(pDriver);
		// TODO Auto-generated constructor stub
	}

	public boolean getFlightProductSummaryPresent() {
		boolean productSummaryPresent = false;
		getWait().until(ExpectedConditions.visibilityOf(flightSummary.get(0)));
		
		if(flightSummary.get(0).isDisplayed()) {
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
	
	public boolean getHotelProductSummaryPresent() {
		boolean productSummaryPresent = false;
		getWait().until(ExpectedConditions.visibilityOf(flightSummary.get(1)));
		
		if(flightSummary.get(1).isDisplayed()) {
			productSummaryPresent = true;
		}
		
		return productSummaryPresent;
		
	}
	
	public boolean getCarProductSummaryPresent() {
		boolean productSummaryPresent = false;
		getWait().until(ExpectedConditions.visibilityOf(flightSummary.get(2)));
		
		if(flightSummary.get(2).isDisplayed()) {
			productSummaryPresent = true;
		}
		
		return productSummaryPresent;
		
	}
	
	public String getHotelNameSelected() {
		return productSelectedList.get(1).getText();
	}
	
	public String getCarTypeSelected() {
		return productSelectedList.get(2).getText();
	}
	
}
