package com.globant.training.app.pages.travelocity;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.training.app.pages.BasePage;

public class CruiseCabinCategoryPage extends BasePage{
	
	private final String TITLE_FARE_SELECTED = "[class='small-title trip-title']";
	private final String CRUISE_DATE_SELECTED = "departure-date";
	private final String DEPARTURE_CITY_SELECTED = "departure-port";
	
	@FindBy(css = TITLE_FARE_SELECTED)
	private WebElement titleFareSelected;
	
	@FindBy(className = CRUISE_DATE_SELECTED)
	private WebElement cruiseDateSelected;
	
	@FindBy(className = DEPARTURE_CITY_SELECTED)
	private WebElement departureCitySelected;
	
	protected CruiseCabinCategoryPage(WebDriver pDriver) {
		super(pDriver);
		// TODO Auto-generated constructor stub
	}

	public void chageOfTab() {
		String currentHandle = getDriver().getWindowHandle();
		Set<String> allHandles = getDriver().getWindowHandles();
		allHandles.remove(currentHandle);
		getDriver().switchTo().window((String) allHandles.toArray()[0]);
	}
	
	public String getTitleSelected() {
		getWait().until(ExpectedConditions.visibilityOf(titleFareSelected));
		return titleFareSelected.getText();
	}
	
	public String getCruiseDateSelected() {
		return cruiseDateSelected.getText().replace("Departing on ", "");
	}
	
	public String getDepartureCitySelected() {
		return departureCitySelected.getText();
	}
	
}
