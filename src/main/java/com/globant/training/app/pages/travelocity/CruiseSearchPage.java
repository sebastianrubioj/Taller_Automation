package com.globant.training.app.pages.travelocity;

import java.util.List;

import org.openqa.selenium.By;
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
	private final String SORT_OPTIONS_PRICE= ".option:nth-of-type(3) [aria-pressed]";
	private final String PROMOTION_LIST="[class='message-flag flex-flag']";
	private final String FARE_CRUISES_LIST = "flex-card";
	private final String DEPARTURE_DATE_LIST = "departing-on";
	private final String DEPARTURE_CITY_LIST = "subtitle-on-ship-image";
	
	public int fareWithoutCorrectDestination;
	public String titleFareSelected;
	public String departureDateSelected;
	public String departureCitySelected;
	
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
	
	@FindBy(css=SORT_OPTIONS_PRICE)
	private WebElement sortOptionsBarPrice;
	
	@FindAll({@FindBy(css=PROMOTION_LIST)})
	private List<WebElement> promotionsList;
	
	@FindAll({@FindBy(className=FARE_CRUISES_LIST)})
	private List<WebElement> fareCruisesList;
	
	@FindAll(@FindBy(className=DEPARTURE_DATE_LIST))
	private List<WebElement> departureDateList;
	
	@FindAll(@FindBy(className=DEPARTURE_CITY_LIST))
	private List<WebElement> departureCityList;
	
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
		getWait().until(ExpectedConditions.elementToBeClickable(sortOptionsBarPrice));
		
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
	
	public boolean arePromotionsPresent() {
		boolean promotionsPresent= false;
		if(promotionsList.size()>0 && fareCruisesList.size()>promotionsList.size()) {
			promotionsPresent = true;
			System.out.println("The total amount of promotions is: " + promotionsList.size());
			System.out.println("The total amount of fares is: " + fareCruisesList.size());
		}
		return promotionsPresent;
		
	}
	
	public CruiseCabinCategoryPage setHigerDiscountFare() {
		
		String totalFares = "//section[@role='main']/div[3]/div";
		int promotion = 0;
		int highestPromo =0;
		int counter=0;
		String highestPromoSelectBtn="Something went wrong";
		String showItinerary="Something went wrong";
	
		for(int i=1; i<getDriver().findElements(By.xpath(totalFares)).size();i++) {
			String fare = "//section[@role='main']/div[3]/div["+i+"]//div[@class='flex-card']/div[2]";
			if(getDriver().findElements(By.xpath(fare)).size()!=0) {
				WebElement cruiseFare= getDriver().findElement(By.xpath(fare));
				counter=counter+1;
				if(cruiseFare.getText().contains("%")) {
					promotion= Integer.parseInt(cruiseFare.getText().replaceAll("([A-z]*)( )*(%)*",""));
					if(promotion>highestPromo) {
						highestPromo=promotion;
						highestPromoSelectBtn = "//section[@role='main']/div[3]/div["+i+"]//div[@class='flex-card']//a[@class='btn btn-secondary btn-action select-sailing-button']";
						System.out.println("Highest promotion so far, to fare " + i + ": " + highestPromo);
						showItinerary= "//section[@role='main']/div[3]/div["+i+"]//div[@class='card-links']//button[text()='Show itinerary']";
						titleFareSelected = titleFareList.get(counter-1).getText();
						departureDateSelected = departureDateList.get(counter-1).getText();
						departureCitySelected = departureCityList.get(counter-1).getText().replaceAll("[^,]*$", "").replace(",", "");
					}
				}
			}
		}
		//Not always the fares have the option to see the Itinerary 
		if(getDriver().findElements(By.xpath(showItinerary)).size()!=0) {
			WebElement showItineraryBtn = getDriver().findElement(By.xpath(showItinerary));
			getWait().until(ExpectedConditions.visibilityOf(showItineraryBtn));
			showItineraryBtn.click();
			getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.className("toggled-map-and-ports"))));
		}
		
		getDriver().findElement(By.xpath(highestPromoSelectBtn)).click();
		return new CruiseCabinCategoryPage(this.getDriver());
	}
}
