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

public class HomePagePackage extends BasePage {

	private final String FLIGHT_HOTEL_CAR_BTN = "[for='fhc-fhc-hp-package']";
	private final String DEPARTURE_PACKAGE = "package-origin-hp-package";
	private final String RETURN_PACKAGE = "package-destination-hp-package";
	private final String DEPARTURE_PACKAGE_DATE = "package-departing-hp-package";
	private final String RETURN_PACKAGE_DATE = "package-returning-hp-package";
	private final String SEARCH_PACKAGE_BTN = "search-button-hp-package";
	private final String AUTOCOMPLETED_DROPDOWN = "typeaheadDataPlain";
	private final String DATE_DROPDOWN = "datepicker-cal";
	private final String NEXT_MONTH_BTN = "datepicker-next";
	/*
	 * To select the day I decided to use this xpath so I can be sure that whenever
	 * you run this scenario this will select a date three months later
	 */
	private final String DATE_PICKER_DAY = "//div[@class='datepicker-cal-month'][2]//tr[2]//td[@class='datepicker-day-number notranslate'][1]";
	private final String DATE_PICKER_DAY_13 = "//div[@class='datepicker-cal-month'][2]//tr[3]//td[@class='datepicker-day-number notranslate'][7]";
	private final String PACKAGES_BTN = "tab-package-tab-hp";
	private final String ADULTS_NUMBER = "package-1-adults-hp-package";
	private final String FLIGHT_HOTEL_BTN = "[class='check col gcw-option'][for='fh-fh-hp-package']";
	private final String PARTIAL_STAY_CHECKBOX = "partialHotelBooking-hp-package";
	private final String CHECK_IN_DATE = "package-checkin-hp-package";
	private final String CHECK_OUT_DATE = "package-checkout-hp-package";
	private final String ERROR_MESSAGE_MISMATCH_DATES = "//div[@class='alert alert-error validation-alert']//li[2]//a[@class='error-link']";
	private final String ERROR_LINK = "error-link";
	private Calendar date = Calendar.getInstance();
	
	@FindBy(css = FLIGHT_HOTEL_CAR_BTN)
	private WebElement flightHotelCarButton;
	
	@FindBy(id = DEPARTURE_PACKAGE)
	private WebElement departurePackageInput;
	
	@FindBy(className = DATE_DROPDOWN)
	private WebElement datePickerDropdown;

	@FindBy(id = AUTOCOMPLETED_DROPDOWN)
	private WebElement autocompletedDropdown;

	@FindBy(className = NEXT_MONTH_BTN)
	private WebElement nextMonthBtn;

	@FindBy(xpath = DATE_PICKER_DAY)
	private WebElement datePickerDay;

	@FindBy(xpath = DATE_PICKER_DAY_13)
	private WebElement datePickerDay13;

	@FindBy(id = PACKAGES_BTN)
	private WebElement packagesButton;

	@FindBy(id = RETURN_PACKAGE)
	private WebElement returnPackageInput;

	@FindBy(id = SEARCH_PACKAGE_BTN)
	private WebElement searchButton;

	@FindBy(id = DEPARTURE_PACKAGE_DATE)
	private WebElement departurePackageDate;

	@FindBy(id = RETURN_PACKAGE_DATE)
	private WebElement returnPackageDate;

	@FindBy(id = ADULTS_NUMBER)
	private WebElement adultsNumber;
	
	@FindBy(css = FLIGHT_HOTEL_BTN)
	private WebElement flightHotelTab;

	@FindBy(id = PARTIAL_STAY_CHECKBOX)
	private WebElement partialStayCheckbox;

	@FindBy(id = CHECK_IN_DATE)
	private WebElement checkinDate;

	@FindBy(id = CHECK_OUT_DATE)
	private WebElement checkoutDate;

	@FindBy(xpath = ERROR_MESSAGE_MISMATCH_DATES)
	private WebElement mismatchDatesMessage;

	@FindBy(className = ERROR_LINK)
	private WebElement errorLink;

	public HomePagePackage(WebDriver pDriver) {
		super(pDriver);
	}

	
	public void setFlightHotelAndCar() {
		flightHotelCarButton.click();
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: Set departure package
	 * @param departureFlight : String
	 */

	public void setDeparturePackage(String departureFlight) {
		setInputString(departurePackageInput, departureFlight);
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: Set return package
	 * @param returnFlight : String
	 */

	public void setReturnPackage(String returnFlight) {
		setInputString(returnPackageInput, returnFlight);
	}

	public void setDeparturePackageDate() {
		departurePackageDate.click();
		getWait().until(ExpectedConditions.visibilityOf(datePickerDropdown));
		nextMonthBtn.click();
		// nextMonthBtn.click();
		datePickerDay.click();
	}

	public void setReturnPackageDate() {
		returnPackageDate.click();
		getWait().until(ExpectedConditions.visibilityOf(datePickerDropdown));
		datePickerDay13.click();
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: click on the search button to go to select an hotel
	 * @return HotelSearchPage
	 */
	public HotelSearchPage setSearchBtn() {
		searchButton.click();
		return new HotelSearchPage(this.getDriver());
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: set number of adults
	 * @param adults : Integer
	 */
	public void setNumberOfAdults(Integer adults) {
		adultsNumber.click();
		adultsNumber.sendKeys(adults.toString());
	}


	/**
	 * @author sebastian.rubio
	 *
	 * @description: select flight + hotel option
	 */
	public void setFlightHotelTab() {
		packagesButton.click();
		flightHotelTab.click();
	}

	public void setPartialStayCheckbox() {
		partialStayCheckbox.click();
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: Set check in date 8 months forward from the current date
	 */

	public void setCheckinDate() {
		setDateForward(checkinDate, 8);
	}

	/**
	 * @author sebastian.rubio
	 *
	 * @description: Set check out date 9 months forward from the current date
	 */

	public void setCheckoutDate() {
		setDateForward(checkoutDate, 9);
	}

	public String getMismatchDatesErrorMessage() {
		getWait().until(ExpectedConditions.visibilityOf(errorLink));
		return errorLink.getText();
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

