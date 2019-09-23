package com.globant.training.app.pages.travelocity;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.training.app.pages.BasePage;

public class CarSearchPage extends BasePage{

	private final String SORT_BAR="offer-sort-bar";
	private final String SELECT_CAR_BTN_LIST = "a[class='btn btn-secondary btn-action ember-view']";
	private final String CAR_TYPE="span[class='bold fullName']";
	public String carTypeSelected;
	
	@FindBy(id=SORT_BAR)
	private WebElement sortBar;
	
	@FindAll({@FindBy(css=SELECT_CAR_BTN_LIST)})
	private List<WebElement> selectCarButtonList;
	
	@FindAll({@FindBy(css=CAR_TYPE)})
	private List<WebElement> carType;
	
	public CarSearchPage(WebDriver pDriver) {
		super(pDriver);
		// TODO Auto-generated constructor stub
	}
	
	public FlightCheckoutPage setCarToRent(int carOptionNumber) {
		getWait().until(ExpectedConditions.visibilityOf(sortBar));
		carTypeSelected=carType.get(carOptionNumber-1).getText();
		selectCarButtonList.get(carOptionNumber-1).click();
		return new FlightCheckoutPage(this.getDriver());
	}
	


}
