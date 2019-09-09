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
	private final String DESTINATION_CITY = ".desktopPlayback .destination.fakeLink";
	private final String HEADER_MESSAGE = "section-header-main";
	private final String NUMBER_OF_ROOMS = "button[class='rooms fakeLink']";
	private final String GO_TOP_PAGE_LINK = "backToTop";
	private final String SORT_BY_PRICE = "button[data-opt-group='Price']";
	private final String PRICES = "[class='actualPrice price fakeLink ']";
	private final String ALL_FARES="resultsContainer";
	
	@FindBy (css=ORIGIN_CITY)
	private WebElement cityOfOrigin;
	
	@FindBy (css=DESTINATION_CITY)
	private WebElement cityOfDestination;
	
	@FindBy(className= HEADER_MESSAGE)
	private WebElement headerMessage;
	
	@FindBy(css= NUMBER_OF_ROOMS)
	private WebElement numberOfRooms;
	
	@FindBy(className= GO_TOP_PAGE_LINK)
	private WebElement goToTopPageLink;
	
	@FindBy(css= SORT_BY_PRICE)
	private WebElement sorteByPrice;
	
	@FindAll({@FindBy(css=PRICES)})
	private List<WebElement> prices; 
	
	@FindBy(id=ALL_FARES)
	private WebElement allFares;
	
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
	
	public int getNumberOfRooms() {
		 return Integer.parseInt(numberOfRooms.getText());
	}
	
	public boolean isTopOfPageLinkPresent() {
		return goToTopPageLink.isDisplayed();
	}
	
	public void setSortByPrice() {
		sorteByPrice.click();
	}
	
	
	public boolean isCorrectlySorted() {
			boolean pricesOrdered= true;
			getWait().until(
					ExpectedConditions.attributeContains(allFares, "class", "container no-outline"));
			System.out.println(prices.size());
		for(int i=0 ; i < prices.size()-1 ;i++) {
			String a = prices.get(i).getText();
			String priceFiltered = a.trim();
			String priceFilteredd = priceFiltered.replace(",", "");
			String priceFiltered1 = priceFilteredd.replace("$", "");
			int price1 = Integer.parseInt(priceFiltered1);
			
			String b = prices.get(i+1).getText();
			String priceFilteredb = b.trim();
			String priceFiltereddb = priceFilteredb.replace(",", "");
			String priceFilteredb1 = priceFiltereddb.replace("$", "");
			int price2 = Integer.parseInt(priceFilteredb1);
			
			if(price1>price2) {
				pricesOrdered=false;
				break;
			}
			
			System.out.println("The price1 is: " + price1 + "  &   The price2 is: " + price2);
		}
		
	return pricesOrdered;
		
	}
	
}
