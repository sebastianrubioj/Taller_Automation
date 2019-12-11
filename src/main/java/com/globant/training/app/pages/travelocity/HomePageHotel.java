package com.globant.training.app.pages.travelocity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.training.app.pages.BasePage;

/**
 * Home Page.
 * 
 * @author sebastian.rubio
 *
 */

public class HomePageHotel extends BasePage {

	private final String AUTOCOMPLETED_DROPDOWN = "typeaheadDataPlain";
	private final String DATE_DROPDOWN = "datepicker-cal";
	/*
	 * To select the day I decided to use this xpath so I can be sure that whenever
	 * you run this scenario this will select a date three months later
	 */
	private final String DATE_PICKER_DAY = "//div[@class='datepicker-cal-month'][2]//tr[2]//td[@class='datepicker-day-number notranslate'][1]";
	private final String HOTEL_TAB = "tab-hotel-tab-hp";
	private final String HOTEL_DESTINATION_INPUT = "hotel-destination-hp-hotel";
	private final String HOTEL_SEARCH_BTN = "[data-gcw-datapreloading-function='hotels'] [data-gcw-change-submit-text='Search']";
	private final String HOTEL_CHECKIN_DATE = "hotel-checkin-hp-hotel";
	private Calendar date = Calendar.getInstance();

	@FindBy(id = AUTOCOMPLETED_DROPDOWN)
	private WebElement autocompletedDropdown;

	@FindBy(className = DATE_DROPDOWN)
	private WebElement datePickerDropdown;

	@FindBy(xpath = DATE_PICKER_DAY)
	private WebElement datePickerDay;

	@FindBy(id = HOTEL_TAB)
	private WebElement hotelTab;

	@FindBy(id = HOTEL_DESTINATION_INPUT)
	private WebElement hotelDestinationInput;

	@FindBy(css = HOTEL_SEARCH_BTN)
	private WebElement hotelSearchBtn;

	@FindBy(id = HOTEL_CHECKIN_DATE)
	private WebElement hotelCheckinDate;

	public HomePageHotel(WebDriver pDriver) {
		super(pDriver);
	}


	/**
	 * @author sebastian.rubio
	 *
	 * @description: Set hotel destination
	 * @param destination : String
	 */

	public void setHotelDestination(String destination) {
		setInputString(hotelDestinationInput, destination);
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: get hotel destination
	 * @return String
	 */

	public String getHotelDestination() {
		getWait().until(ExpectedConditions.visibilityOf(hotelDestinationInput));
		getWait().until(ExpectedConditions.elementToBeClickable(hotelDestinationInput));
		return hotelDestinationInput.getText();
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: click on the search button to go to select an hotel
	 * @return HotelSearchPage
	 */
	public HotelSearchPage setSearchHotel() {
		getWait().until(ExpectedConditions.visibilityOf(hotelSearchBtn));
		getWait().until(ExpectedConditions.elementToBeClickable(hotelSearchBtn));
		hotelSearchBtn.click();
		return new HotelSearchPage(this.getDriver());
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: 
	 * @return HotelSearchPage
	 */
	public void setHotelCheckinDate() {
		hotelCheckinDate.click();
		getWait().until(ExpectedConditions.visibilityOf(datePickerDropdown));
		datePickerDay.click();
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: Set input to any text box on Home Page
	 * @param inputElement : WebElement
	 * @param inputString  : String
	 * 
	 */

	public void setInputString(WebElement inputElement, String inputString) {
		getWait().until(ExpectedConditions.visibilityOf(inputElement));
		getWait().until(ExpectedConditions.elementToBeClickable(inputElement));
		inputElement.sendKeys(inputString);
		inputElement.sendKeys(Keys.SPACE);
		getWait().until(ExpectedConditions.visibilityOf(autocompletedDropdown));
		inputElement.sendKeys(Keys.TAB);
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: Set a date an amount of months forward from the current date
	 * @param inputElement : WebElement
	 * @param inputString  : String
	 * 
	 */

	public void setDateForward(WebElement element, int monthsForward) {
		getWait().until(ExpectedConditions.visibilityOf(element));
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		date.setTime(new Date());
		date.add(Calendar.MONTH, monthsForward);
		element.click();
		element.clear();
		setLoggerInfo("check out date: " + formatter.format(date.getTime()));
		element.sendKeys(formatter.format(date.getTime()));
	}
}
