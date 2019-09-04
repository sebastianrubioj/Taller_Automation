package com.globant.training.app.pages.travelocity;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.training.app.pages.BasePage;

public class FlightInformationPage extends BasePage {

	private final String TOTAL_PRICE = ".desktopView .packagePriceTotal";
	private final String FLIGHT_INFO = "flightSummary";
	private final String PRICE_GUARANTEE = ".desktopView .priceGuarantee";
	private final String CONTINUE_BOOKING_BTN = "bookButton";
	//private final String DEPARTURE_INFO = "div.OD0";
	//private final String RETURN_INFO = "div.OD1";
	
	public FlightInformationPage(WebDriver pDriver) {
		super(pDriver);
	}
	
	@FindBy(css = TOTAL_PRICE)
	private WebElement totalPrice;
	
	@FindBy(className = FLIGHT_INFO)
	private WebElement flightInfo;
	
	@FindBy(css= PRICE_GUARANTEE)
	private WebElement priceGuarantee;
	
	@FindBy(id= CONTINUE_BOOKING_BTN)
	private WebElement continueBookingBtn;
	
	
	public boolean getTotalPricePresent() {
		
		String currentHandle = getDriver().getWindowHandle();
		Set<String> allHandles = getDriver().getWindowHandles();
		allHandles.remove(currentHandle);
		getDriver().switchTo().window((String) allHandles.toArray()[0]);
		
		getWait().until(ExpectedConditions.visibilityOf(totalPrice));
		boolean pricePresent = false;
		if(totalPrice.isDisplayed() && totalPrice.getText() != null) {
			pricePresent = true;
			System.out.println("the total price of the flight is: " + totalPrice.getText());
		}
		return pricePresent;
	}
	
	public boolean getFlightInfoIsPresent() {
		boolean infoPresent= false;
		if(flightInfo.isDisplayed()) {
			infoPresent = true;
		}
		return infoPresent;
	}
	
	public boolean getFlightGuaranteeTextPresent (){
		boolean flightGuaranteePresent = false;
		
		if(priceGuarantee.isDisplayed() && !priceGuarantee.getText().isEmpty()) {
			flightGuaranteePresent = true;
		}
		
		return flightGuaranteePresent;
	}
	
	public FlightCheckoutPage setContinueBooking() {
		continueBookingBtn.click();
		return new FlightCheckoutPage(this.getDriver());
	}
	
}
