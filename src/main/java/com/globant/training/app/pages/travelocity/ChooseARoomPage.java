package com.globant.training.app.pages.travelocity;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.training.app.pages.BasePage;

public class ChooseARoomPage extends BasePage{

	private final String PRICE="[class='price link-to-rooms']";
	private final String HOTEL_NAME="hotel-name";
	private final String STARS="#license-plate .star.rating";
	private final String SELECT_ROOM_BTN_LIST = ".room-above-fold .book-button-wrapper";
	
	@FindBy(css=PRICE)
	private WebElement price;
	
	@FindBy(id=HOTEL_NAME)
	private WebElement hotelName;
	
	@FindBy(css=STARS)
	private WebElement starsNumber;
	
	@FindAll({@FindBy(css=SELECT_ROOM_BTN_LIST)})
	private List<WebElement> selectRoomBtnList; 
	
	protected ChooseARoomPage(WebDriver pDriver) {
		super(pDriver);
		// TODO Auto-generated constructor stub
	}

	public String getPrice() {
		String currentHandle = getDriver().getWindowHandle();
		Set<String> allHandles = getDriver().getWindowHandles();
		allHandles.remove(currentHandle);
		getDriver().switchTo().window((String) allHandles.toArray()[0]);
		getWait().until(ExpectedConditions.visibilityOf(price));
		return price.getText();
	}
	
	public String getHotelName() {
		return hotelName.getText();
	}
	
	public double getStarsNumber() {
		String starsText = starsNumber.getText();
		String stars = starsText.replace("out of 5.0", "");
		double starsN = Double.parseDouble(stars);
		return starsN;
	}
	
	public FlightSearchPage setRoom(int optionNumber) {
		selectRoomBtnList.get(optionNumber-1).click();
		return new FlightSearchPage(this.getDriver());
	}
	
}
