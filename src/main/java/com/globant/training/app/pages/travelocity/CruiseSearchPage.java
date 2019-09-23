package com.globant.training.app.pages.travelocity;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.training.app.pages.BasePage;

public class CruiseSearchPage extends BasePage{

	private final String DESTINATION_SELECTED= "destination-select";
	private final String ADULTS_NUMBER_SELECTED= "travelers-select";
	private final String TITLE_FARE_LIST="title-on-ship-image";
	private final String NIGHTS_10_14_FILTER_CHECKBOX="//div[@id='cruise-search-display']//input[@name='length-10-14']";
	private final String FARE_RESULTS= "[class='col search-results']";
	private final String SORT_OPTIONS= "[class='sort-options nobullet']";
	
	public int fareWithoutCorrectDestination;
	
	@FindBy(id=DESTINATION_SELECTED)
	private WebElement destinationSelected;
	
	@FindBy(id=ADULTS_NUMBER_SELECTED)
	private WebElement adultsNumberSelected;
	
	@FindAll({@FindBy(className=TITLE_FARE_LIST)})
	private List<WebElement> titleFareList;
	
	@FindBy(xpath=NIGHTS_10_14_FILTER_CHECKBOX)
	private WebElement nights10To14NightsFilterCheckbox;
	
	@FindBy(css=FARE_RESULTS)
	private WebElement fareResults;
	
	@FindBy(css=SORT_OPTIONS)
	private WebElement sortOptionsBar;
	
	protected CruiseSearchPage(WebDriver pDriver) {
		super(pDriver);
		// TODO Auto-generated constructor stub
	}	
	
	public String getDestinationSelected() {
		getWait().until(ExpectedConditions.visibilityOf(destinationSelected));
		return destinationSelected.getText();
	}
	
	public int getAdultsNumberSelected() {
		return Integer.parseInt(adultsNumberSelected.getText().replace(" adults", ""));
	}
	
	public boolean isCorrectDestinationPresentInAllFares(String destination) {
		boolean destinationPresent=true;
		getWait().until(ExpectedConditions.visibilityOf(fareResults));
		for(int i=0; i< titleFareList.size(); i++) {
			
			if(!titleFareList.get(i).getText().contains(destination)) {
				destinationPresent = false;
				fareWithoutCorrectDestination = i;
				break;
			}
		}
		
		return destinationPresent;
	}
	
	public void setNights10To14FilterCheckbox() {
		nights10To14NightsFilterCheckbox.click();
	}
	
	public boolean isAllSorted10To14Nights() {
		boolean isSortedCorrectly=true;
		getWait().until(ExpectedConditions.elementToBeClickable(sortOptionsBar));
		
		for(int i=0; i< titleFareList.size(); i++) {
			String titleFare = titleFareList.get(i).getText().replaceAll("([A-z]*)( )*", "");
			int nights = Integer.parseInt(titleFare);
			System.out.println(nights);
			if(nights<10 || nights>14) {
				isSortedCorrectly = false;
				//fareWithoutCorrectDestination = i;
				break;
			}
		}
		
		return isSortedCorrectly;
	}
}
