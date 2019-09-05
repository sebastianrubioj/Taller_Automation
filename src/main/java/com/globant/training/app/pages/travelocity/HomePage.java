package com.globant.training.app.pages.travelocity;

import javax.annotation.ParametersAreNonnullByDefault;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;

import com.globant.training.app.pages.BasePage;

public class HomePage extends BasePage{
	
	
	private final String FLIGHT_BTN = "tab-flight-tab-hp";
	private final String DEPARTURE = "flight-origin-hp-flight";
	private final String RETURN = "flight-destination-hp-flight";
	private final String DEPARTURE_DATE = "flight-departing-hp-flight";
	private final String RETURN_DATE ="flight-returning-hp-flight";
	private final String AUTOCOMPLETED_DROPDOWN ="typeaheadDataPlain";
	private final String DATE_DROPDOWN = "datepicker-cal";
	private final String NEXT_MONTH_BTN = "datepicker-next";
	//To select the day I decided to use this xpath so I can be sure that whenever you run this scenario this will select a date three months later
	private final String DATE_PICKER_DAY = "//div[@class='datepicker-cal-month'][2]//tr[2]//td[@class='datepicker-day-number notranslate'][1]";
	private final String DATE_PICKER_DAY_18 = "//div[@class='datepicker-cal-month'][2]//tr[4]//td[@class='datepicker-day-number notranslate'][5]";
	private final String SEARCH_FLIGHT = "[data-gcw-key='hp-flight'] [data-gcw-change-submit-text='Search']";
	private final String PACKAGES_BTN = "tab-package-tab-hp";
	private final String FLIGHT_HOTEL_CAR_BTN = "[for='fhc-fhc-hp-package']";
	private final String DEPARTURE_PACKAGE = "package-origin-hp-package";
	private final String RETURN_PACKAGE = "package-destination-hp-package";
	private final String DEPARTURE_PACKAGE_DATE = "package-departing-hp-package";
	private final String RETURN_PACKAGE_DATE ="package-returning-hp-package";
	private final String SEARCH_PACKAGE_BTN = "search-button-hp-package";
	
	
	@FindBy(id = FLIGHT_BTN)
	private WebElement flightButton;
	
	@FindBy(id = DEPARTURE)
	private WebElement departureInput;
	
	@FindBy(id= AUTOCOMPLETED_DROPDOWN)
	private WebElement autocompletedDropdown;
	
	@FindBy(id = RETURN)
	private WebElement returnInput;

	@FindBy(id = DEPARTURE_DATE)
	private WebElement departureDateInput;
	

	@FindBy(id = RETURN_DATE)
	private WebElement returnDateInput;
	

	@FindBy(className= DATE_DROPDOWN)
	private WebElement datePickerDropdown;

	@FindBy(className= NEXT_MONTH_BTN)
	private WebElement nextMonthBtn;
	
	@FindBy(xpath= DATE_PICKER_DAY)
	private WebElement datePickerDay;
	
	@FindBy(xpath= DATE_PICKER_DAY_18)
	private WebElement datePickerDay18;
	
	@FindBy(css= SEARCH_FLIGHT)
	private WebElement searchFlight;
	
	@FindBy(id= PACKAGES_BTN)
	private WebElement packagesButton;

	@FindBy(css= FLIGHT_HOTEL_CAR_BTN)
	private WebElement flightHotelCarButton;
	
	@FindBy(id= DEPARTURE_PACKAGE)
	private WebElement departurePackageInput;
	
	@FindBy(id= RETURN_PACKAGE)
	private WebElement returnPackageInput;
	
	@FindBy(id= SEARCH_PACKAGE_BTN)
	private WebElement searchButton;
	
	@FindBy(id= DEPARTURE_PACKAGE_DATE)
	private WebElement departurePackageDate;

	@FindBy(id= RETURN_PACKAGE_DATE)
	private WebElement returnPackageDate;
	
	@Parameters({"url"})
	public HomePage(WebDriver pDriver){
		super(pDriver);
		String url = "https://www.travelocity.com/";
		getDriver().get(url);
	}
	
	
	public void setFlightButton() {
		flightButton.click();
	}
	
	public void setDepartureFlight(String departureFlight) {
		getWait().until(ExpectedConditions.visibilityOf(departureInput));
		departureInput.sendKeys(departureFlight);
		departureInput.sendKeys(Keys.SPACE);
		getWait().until(ExpectedConditions.visibilityOf(autocompletedDropdown));
		departureInput.sendKeys(Keys.TAB);
	}
	
	public void setArrivalFlight(String returnFlight) {
		getWait().until(ExpectedConditions.visibilityOf(returnInput));
		returnInput.sendKeys(returnFlight);
		returnInput.sendKeys(Keys.SPACE);
		getWait().until(ExpectedConditions.visibilityOf(autocompletedDropdown));
		returnInput.sendKeys(Keys.TAB);
	}
	
	public void setDepartureDate() {
		departureDateInput.click();
		getWait().until(ExpectedConditions.visibilityOf(datePickerDropdown));
		nextMonthBtn.click();
		nextMonthBtn.click();
		datePickerDay.click();
		
	}
	
	public void setReturnDate() {
		returnDateInput.click();
		getWait().until(ExpectedConditions.visibilityOf(datePickerDropdown));
		nextMonthBtn.click();
		datePickerDay.click();
	}
	
	public FlightSearchPage setSearchFlight(){
		searchFlight.click();
		return new FlightSearchPage(this.getDriver());
	}
	
	public void setFlightHotelAndCar() {
		packagesButton.click();
		flightHotelCarButton.click();
	}
	
	public void setDeparturePackage(String departureFlight) {
		getWait().until(ExpectedConditions.visibilityOf(departurePackageInput));
		getWait().until(ExpectedConditions.elementToBeClickable(departurePackageInput));
		departurePackageInput.sendKeys(departureFlight);
		departurePackageInput.sendKeys(Keys.SPACE);
		getWait().until(ExpectedConditions.visibilityOf(autocompletedDropdown));
		departurePackageInput.sendKeys(Keys.TAB);
	}
	
	public void setReturnPackage(String returnFlight) {
		getWait().until(ExpectedConditions.visibilityOf(returnPackageInput));
		getWait().until(ExpectedConditions.elementToBeClickable(returnPackageInput));
		returnPackageInput.sendKeys(returnFlight);
		returnPackageInput.sendKeys(Keys.SPACE);
		getWait().until(ExpectedConditions.visibilityOf(autocompletedDropdown));
		returnPackageInput.sendKeys(Keys.TAB);
	}
	
	public void setDeparturePackageDate() {
		departurePackageDate.click();
		getWait().until(ExpectedConditions.visibilityOf(datePickerDropdown));
		nextMonthBtn.click();
		nextMonthBtn.click();
		datePickerDay.click();
	}
	
	public void setReturnPackageDate() {
		returnPackageDate.click();
		getWait().until(ExpectedConditions.visibilityOf(datePickerDropdown));
		datePickerDay18.click();
	}
	
	public HotelSearchPage setSearchBtn() {
		searchButton.click();
		return new HotelSearchPage(this.getDriver());
	}
	
}
