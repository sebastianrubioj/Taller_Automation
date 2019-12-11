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

public class HomePageFlight extends BasePage {

	private final String FLIGHT_BTN = "tab-flight-tab-hp";
	private final String DEPARTURE = "flight-origin-hp-flight";
	private final String RETURN = "flight-destination-hp-flight";
	private final String DEPARTURE_DATE = "flight-departing-hp-flight";
	private final String RETURN_DATE = "flight-returning-hp-flight";
	private final String AUTOCOMPLETED_DROPDOWN = "typeaheadDataPlain";
	private final String DATE_DROPDOWN = "datepicker-cal";
	private final String NEXT_MONTH_BTN = "datepicker-next";
	/*
	 * To select the day I decided to use this xpath so I can be sure that whenever
	 * you run this scenario this will select a date three months later
	 */
	private final String DATE_PICKER_DAY = "//div[@class='datepicker-cal-month'][2]//tr[2]//td[@class='datepicker-day-number notranslate'][1]";
	private final String DATE_PICKER_DAY_13 = "//div[@class='datepicker-cal-month'][2]//tr[3]//td[@class='datepicker-day-number notranslate'][7]";
	private final String SEARCH_FLIGHT = "[data-gcw-key='hp-flight'] [data-gcw-change-submit-text='Search']";
	
	private Calendar date = Calendar.getInstance();
	
	@FindBy(id = FLIGHT_BTN)
	private WebElement flightButton;

	@FindBy(id = DEPARTURE)
	private WebElement departureInput;

	@FindBy(id = AUTOCOMPLETED_DROPDOWN)
	private WebElement autocompletedDropdown;

	@FindBy(id = RETURN)
	private WebElement returnInput;

	@FindBy(id = DEPARTURE_DATE)
	private WebElement departureDateInput;

	@FindBy(id = RETURN_DATE)
	private WebElement returnDateInput;

	@FindBy(className = DATE_DROPDOWN)
	private WebElement datePickerDropdown;

	@FindBy(className = NEXT_MONTH_BTN)
	private WebElement nextMonthBtn;

	@FindBy(xpath = DATE_PICKER_DAY)
	private WebElement datePickerDay;

	@FindBy(xpath = DATE_PICKER_DAY_13)
	private WebElement datePickerDay13;

	@FindBy(css = SEARCH_FLIGHT)
	private WebElement searchFlight;

	public HomePageFlight(WebDriver pDriver) {
		super(pDriver);
		}

	public void setFlightButton() {
		flightButton.click();
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: Set departure flight
	 * @param departureFlight : String
	 */

	public void setDepartureFlight(String departureFlight) {
		setInputString(departureInput, departureFlight);
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: Set arrival flight
	 * @param departureFlight : String
	 */

	public void setArrivalFlight(String returnFlight) {
		setInputString(returnInput, returnFlight);
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: Set the departure date on the calendar
	 */
	public void setDepartureDate() {
		departureDateInput.click();
		getWait().until(ExpectedConditions.visibilityOf(datePickerDropdown));
		nextMonthBtn.click();
		nextMonthBtn.click();
		datePickerDay.click();

	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: Set the return date on the calendar
	 */
	public void setReturnDate() {
		returnDateInput.click();
		getWait().until(ExpectedConditions.visibilityOf(datePickerDropdown));
		nextMonthBtn.click();
		datePickerDay.click();
		// datePickerDay18.click();
	}

	public FlightSearchPage setSearchFlight() {
		searchFlight.click();
		return new FlightSearchPage(this.getDriver());
	}


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
