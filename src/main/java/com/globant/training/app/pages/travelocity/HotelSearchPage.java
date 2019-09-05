package com.globant.training.app.pages.travelocity;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.training.app.pages.BasePage;

public class HotelSearchPage extends BasePage{

	private final String ORIGIN_CITY = "button[class='origin fakeLink']";
	private final String DESTINATION_CITY = "button[class='destination fakeLink']";
	private final String HEADER_MESSAGE = "section-header-main";
	private final String CHOOSE_LABELS = "msi-label-refresh";
	
	@FindBy (css=ORIGIN_CITY)
	private WebElement cityOfOrigin;
	
	@FindBy (css=DESTINATION_CITY)
	private WebElement cityOfDestination;
	
	@FindBy(className= HEADER_MESSAGE)
	private WebElement headerMessage;
	
	@FindAll({@FindBy(className= CHOOSE_LABELS)})
	private List<WebElement> chooseLabels;
	
	protected HotelSearchPage(WebDriver pDriver) {
		super(pDriver);
		// TODO Auto-generated constructor stub
	}

	public String getOriginCity() {
		getWait().until(ExpectedConditions.visibilityOf(headerMessage));
		return cityOfOrigin.getText();
	}
	
	public String getDestinationCity() {
		return cityOfDestination.getText();
	}
	
	public String getHeaderMessage() {
		return headerMessage.getText();
	}
	
}
