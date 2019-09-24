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
	private final String DATE_PICKER_DAY_13 = "//div[@class='datepicker-cal-month'][2]//tr[3]//td[@class='datepicker-day-number notranslate'][7]";
	private final String SEARCH_FLIGHT = "[data-gcw-key='hp-flight'] [data-gcw-change-submit-text='Search']";
	private final String PACKAGES_BTN = "tab-package-tab-hp";
	private final String FLIGHT_HOTEL_CAR_BTN = "[for='fhc-fhc-hp-package']";
	private final String DEPARTURE_PACKAGE = "package-origin-hp-package";
	private final String RETURN_PACKAGE = "package-destination-hp-package";
	private final String DEPARTURE_PACKAGE_DATE = "package-departing-hp-package";
	private final String RETURN_PACKAGE_DATE ="package-returning-hp-package";
	private final String SEARCH_PACKAGE_BTN = "search-button-hp-package";
	private final String ADULTS_NUMBER = "package-1-adults-hp-package";
	private final String HOTEL_TAB = "tab-hotel-tab-hp";
	private final String HOTEL_DESTINATION_INPUT = "hotel-destination-hp-hotel";
	private final String HOTEL_SEARCH_BTN = "[data-gcw-datapreloading-function='hotels'] [data-gcw-change-submit-text='Search']";
	private final String FLIGHT_HOTEL_BTN = "[class='check col gcw-option'][for='fh-fh-hp-package']";
	private final String PARTIAL_STAY_CHECKBOX = "partialHotelBooking-hp-package";
	private final String CHECK_IN_DATE = "package-checkin-hp-package";
	private final String CHECK_OUT_DATE= "package-checkout-hp-package";
	private final String ERROR_MESSAGE_MISMATCH_DATES = "//div[@class='alert alert-error validation-alert']//li[2]//a[@class='error-link']";
	private final String CRUISE_TAB = "tab-cruise-tab-hp";
	private final String DESTINATION_CRUISES_DROPDOWN= "cruise-destination-hp-cruise";
	private final String CRUISE_START_DATE ="cruise-start-date-hp-cruise";
	private final String CRUISE_END_DATE = "cruise-end-date-hp-cruise";
	private final String SEARCH_CRUISE_BTN = "[data-gcw-key='hp-cruise'] .btn-primary";
	private final String ADULTS_NUMBER_CRUISE = "cruise-adults-hp-cruise";
	private final String HOTEL_CHECKIN_DATE = "hotel-checkin-hp-hotel";

	
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
	
	@FindBy(xpath= DATE_PICKER_DAY_13)
	private WebElement datePickerDay13;
	
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
	
	@FindBy(id= ADULTS_NUMBER)
	private WebElement adultsNumber;
	
	@FindBy(id=HOTEL_TAB)
	private WebElement hotelTab;
	
	@FindBy(id=HOTEL_DESTINATION_INPUT)
	private WebElement hotelDestinationInput;
	
	@FindBy(css=HOTEL_SEARCH_BTN)
	private WebElement hotelSearchBtn;
	
	@FindBy(css=FLIGHT_HOTEL_BTN)
	private WebElement flightHotelTab;
	
	@FindBy(id= PARTIAL_STAY_CHECKBOX)
	private WebElement partialStayCheckbox;
	
	@FindBy(id= CHECK_IN_DATE)
	private WebElement checkinDate;
	
	@FindBy(id= CHECK_OUT_DATE)
	private WebElement checkoutDate;
	
	@FindBy(xpath= ERROR_MESSAGE_MISMATCH_DATES)
	private WebElement mismatchDatesMessage;
	
	@FindBy(id=CRUISE_TAB)
	private WebElement cruiseTab;
	
	@FindBy(id=DESTINATION_CRUISES_DROPDOWN)
	private WebElement destinationCruisesDropdown;
	
	@FindBy(id= CRUISE_START_DATE)
	private WebElement cruiseStartDate;
	
	@FindBy(id= CRUISE_END_DATE)
	private WebElement cruiseEndDate;
	
	@FindBy(css= SEARCH_CRUISE_BTN)
	private WebElement searchCruiseBtn;
	
	@FindBy(id=ADULTS_NUMBER_CRUISE)
	private WebElement adultsNumberCruise;
	
	@FindBy(id= HOTEL_CHECKIN_DATE)
	private WebElement hotelCheckinDate;
	
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
		//datePickerDay18.click();
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
		//nextMonthBtn.click();
		datePickerDay.click();
	}
	
	public void setReturnPackageDate() {
		returnPackageDate.click();
		getWait().until(ExpectedConditions.visibilityOf(datePickerDropdown));
		datePickerDay13.click();
	}
	
	public HotelSearchPage setSearchBtn() {
		searchButton.click();
		return new HotelSearchPage(this.getDriver());
	}
	
	public void setNumberOfAdults(Integer adults) {
		adultsNumber.click();
		adultsNumber.sendKeys(adults.toString());
	}
	
	public void setHotelTab() {
		hotelTab.click();
	}
	
	public void setHotelDestination(String destination) {
		getWait().until(ExpectedConditions.visibilityOf(hotelDestinationInput));
		getWait().until(ExpectedConditions.elementToBeClickable(hotelDestinationInput));
		hotelDestinationInput.sendKeys(destination);
		hotelDestinationInput.sendKeys(Keys.SPACE);
		getWait().until(ExpectedConditions.visibilityOf(autocompletedDropdown));
		hotelDestinationInput.sendKeys(Keys.ENTER);
	}
	
	public String getHotelDestination() {
		getWait().until(ExpectedConditions.visibilityOf(hotelDestinationInput));
		getWait().until(ExpectedConditions.elementToBeClickable(hotelDestinationInput));
		return hotelDestinationInput.getText();
	}
	
	public HotelSearchPage setSearchHotel() {
		//getWait().until(ExpectedConditions.elementToBeClickable(hotelSearchBtn));
		hotelSearchBtn.click();
		return new HotelSearchPage(this.getDriver());
	}
	
	public void setFlightHotelTab() {
		packagesButton.click();
		flightHotelTab.click();
	}
	
	public void setPartialStayCheckbox(){
		partialStayCheckbox.click();
	}
	
	public void setCheckinDate(String date){
		getWait().until(ExpectedConditions.visibilityOf(checkinDate));
		checkinDate.click();
		checkinDate.clear();
		checkinDate.sendKeys(date);
	}
	
	public void setCheckoutDate(String date){
		getWait().until(ExpectedConditions.visibilityOf(checkoutDate));
		checkoutDate.click();
		checkoutDate.clear();
		checkoutDate.sendKeys(date);
	}
	
	public String getMismatchDatesErrorMessage() {
		getWait().until(ExpectedConditions.visibilityOf(mismatchDatesMessage));
		return mismatchDatesMessage.getText();
	}
	
	public void setCruisesTabSelect() {
		cruiseTab.click();
	}
	
	public void setCruisesDestination(String destination) {
		getWait().until(ExpectedConditions.visibilityOf(destinationCruisesDropdown));
		getWait().until(ExpectedConditions.elementToBeClickable(destinationCruisesDropdown));
		destinationCruisesDropdown.click();
		destinationCruisesDropdown.sendKeys(destination);
	}
	
	public void setStartCruiseDate(String date) {
		cruiseStartDate.click();
		cruiseStartDate.clear();
		cruiseStartDate.sendKeys(date);
	}
	
	public void setEndCruiseDate(String date) {
		cruiseEndDate.click();
		cruiseEndDate.clear();
		cruiseEndDate.sendKeys(date);
	}
	
	public void SetAdultsCruiseNumber(int adulstsNumber) {
		getWait().until(ExpectedConditions.elementToBeClickable(adultsNumberCruise));
		adultsNumberCruise.click();
		adultsNumberCruise.sendKeys(adultsNumber.toString());
	}
	
	public CruiseSearchPage setSearchCruises() {
		searchCruiseBtn.click();
		return new CruiseSearchPage(getDriver());
	}
	
	public void setHotelCheckinDate() {
		hotelCheckinDate.click();
		getWait().until(ExpectedConditions.visibilityOf(datePickerDropdown));
		datePickerDay.click();
		
	}
}
