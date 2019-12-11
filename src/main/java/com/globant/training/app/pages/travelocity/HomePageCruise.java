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

public class HomePageCruise extends BasePage {

	private final String AUTOCOMPLETED_DROPDOWN = "typeaheadDataPlain";
	private final String DESTINATION_CRUISES_DROPDOWN = "cruise-destination-hp-cruise";
	private final String CRUISE_START_DATE = "cruise-start-date-hp-cruise";
	private final String SEARCH_CRUISE_BTN = "[data-gcw-key='hp-cruise'] .btn-primary";
	private final String ADULTS_NUMBER_CRUISE = "cruise-adults-hp-cruise";
	private Calendar date = Calendar.getInstance();

	@FindBy(id = AUTOCOMPLETED_DROPDOWN)
	private WebElement autocompletedDropdown;

	@FindBy(id = DESTINATION_CRUISES_DROPDOWN)
	private WebElement destinationCruisesDropdown;

	@FindBy(id = CRUISE_START_DATE)
	private WebElement cruiseStartDate;

	@FindBy(css = SEARCH_CRUISE_BTN)
	private WebElement searchCruiseBtn;

	@FindBy(id = ADULTS_NUMBER_CRUISE)
	private WebElement adultsNumberCruise;

	public HomePageCruise(WebDriver pDriver) {
		super(pDriver);
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: Set cruise destination
	 * @param destination : String
	 */

	public void setCruisesDestination(String destination) {
		getWait().until(ExpectedConditions.visibilityOf(destinationCruisesDropdown));
		getWait().until(ExpectedConditions.elementToBeClickable(destinationCruisesDropdown));
		destinationCruisesDropdown.click();
		destinationCruisesDropdown.sendKeys(destination);
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: Set the date to start the cruise allowing to select an amount
	 *               of months forward from the current date.
	 * @param monthsForward : Integer
	 */

	public void setStartCruiseDate(int monthsForward) {
		setDateForward(cruiseStartDate, monthsForward);
	}

	public void SetAdultsCruiseNumber(int adultsNumber) {
		getWait().until(ExpectedConditions.elementToBeClickable(adultsNumberCruise));
		adultsNumberCruise.click();
		String adults = Integer.toString(adultsNumber);
		adultsNumberCruise.sendKeys(adults);
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: click on the search cruise button
	 * @return CruiseSearchPage
	 */

	public CruiseSearchPage setSearchCruises() {
		searchCruiseBtn.click();
		return new CruiseSearchPage(getDriver());
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
