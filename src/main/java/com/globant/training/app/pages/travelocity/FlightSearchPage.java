package com.globant.training.app.pages.travelocity;

import java.beans.Visibility;
import java.util.List;

import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.globant.training.app.pages.BasePage;

import net.bytebuddy.implementation.bytecode.constant.SerializedConstant;

public class FlightSearchPage extends BasePage {

	private final String SORT_DROPDOWN_BOX = "sortDropdown";
	private final String FLIGHT_LIST = "offer-listing";
	private final String FLIGHT_SELECT_BTN = "div[class='uitk-col standard-col-l-margin all-col-shrink display-larger-screens-only'] button";
	private final String RULES_AND_RESTRICTIONS_BTN_LIST = ".flight-module .basic-economy-tray button";
	// private final String SELECT_THIS_FARE_BTN = "div[class='basic-economy-tray
	// uitk-grid'] button[class='btn-secondary btn-action t-select-btn']";
	private final String FLIGHT_SEARCH_RESULT = "flightModuleList";
	private final String FLIGHT_DURATION = "duration-emphasis";
	private final String PROGRESS_BAR = "div[class='progress-bar'] div[style='width: 100%;']";
	private final String FLIGHT_DETAIL_FEES = "show-flight-details";
	private final String FLIGHT_TEXT = "title-city-text";
	public int buttonMissed;
	public int durationMissed;
	public int fareDetailMissed;

	public FlightSearchPage(WebDriver pDriver) {
		super(pDriver);
	}

	@FindBy(id = SORT_DROPDOWN_BOX)
	private WebElement sortDropdownElement;

	@FindAll({ @FindBy(className = FLIGHT_LIST) })
	private List<WebElement> allFlightList;

	@FindAll({ @FindBy(css = FLIGHT_SELECT_BTN) })
	private List<WebElement> flightSelectBtn;

	
	 @FindAll({@FindBy (css = RULES_AND_RESTRICTIONS_BTN_LIST)}) 
	 private List<WebElement> rulesAndRestrictionAccordionList;
	 

	@FindBy(id = FLIGHT_SEARCH_RESULT)
	private WebElement allFlights;

	@FindAll({ @FindBy(className = FLIGHT_DURATION) })
	private List<WebElement> FlightDuration;

	@FindBy(css = PROGRESS_BAR)
	private WebElement progressBar;

	@FindAll({ @FindBy(className = FLIGHT_DETAIL_FEES) })
	private List<WebElement> flightDetailsAndFees;

	@FindBy(className = FLIGHT_TEXT)
	private WebElement flightText;

	public boolean getDropDownBox() {
		getWait().until(ExpectedConditions.visibilityOf(sortDropdownElement));
		return sortDropdownElement.isDisplayed();
	}

	public boolean getselectBtnForAllFlights() {
		boolean buttonPresent = false;
		getWait().until(ExpectedConditions.invisibilityOf(progressBar));

		// Comparison between the number of fare select buttons and the number of fares
		if (flightSelectBtn.size() == allFlightList.size()) {
			buttonPresent = true;
			for (int i = 0; i < allFlightList.size(); i++) {
				if (!flightSelectBtn.get(i).isDisplayed()) {
					buttonPresent = false;
					buttonMissed = i;
					break;
				}
			}
		} else {
			System.out.println(
					"Comparison between the number of fare search buttons and the number of fares doesn't match");
		}

		System.out.println("Number of select Button: " + flightSelectBtn.size());

		return buttonPresent;
	}

	public boolean getFlightDurationForAllFares() {
		boolean flightDurationPresent = false;

		if (FlightDuration.size() == allFlightList.size()) {
			flightDurationPresent = true;

			for (int i = 0; i < allFlightList.size(); i++) {
				if (!FlightDuration.get(i).isDisplayed()) {
					flightDurationPresent = false;
					durationMissed = i;
					break;
				}
			}
		} else {
			System.out
					.println("Comparison between the number of flight durations and the number of fares doesn't match");
		}

		System.out.println("Number of Flight Duration info: " + FlightDuration.size());

		return flightDurationPresent;
	}

	public boolean getFlightDetailsForAllFares() {
		boolean flightDetailsPresent = false;

		if (flightDetailsAndFees.size() == allFlightList.size()) {
			flightDetailsPresent = true;

			for (int i = 0; i < allFlightList.size(); i++) {
				if (!flightDetailsAndFees.get(i).isDisplayed()) {
					flightDetailsPresent = false;
					fareDetailMissed = i;
					break;
				}
			}
		} else {
			System.out.println("Comparison between the number of flight details and the number of fares doesn't match");
		}

		System.out.println("Number of Detail and Fees: " + flightDetailsAndFees.size());
		System.out.println("Number of fares: " + allFlightList.size());
		return flightDetailsPresent;
	}

	public void setStoreByDuration() {
		sortDropdownElement.click();
		sortDropdownElement.sendKeys("Duration (Shortest)");
		sortDropdownElement.sendKeys(Keys.ENTER);
	}

	public boolean getFaresOrderByDuration() {

		boolean faresOrdered = true;

		getWait().until(
				ExpectedConditions.attributeContains(allFlights, "class", "segmented-list results-list duration-sort"));

		for (int i = 0; i < FlightDuration.size() - 1; i++) {

			String a = FlightDuration.get(i).getText();
			String[] number = a.split(" ");
			String filtered1 = number[0].replaceAll("h", "");
			String filtered2 = number[1].replaceAll("m", "");
			int hour = Integer.parseInt(filtered1);
			int min = Integer.parseInt(filtered2);

			String b = FlightDuration.get(i + 1).getText();
			String[] number2 = b.split(" ");
			String filtered3 = number2[0].replaceAll("h", "");
			String filtered4 = number2[1].replaceAll("m", "");
			int hour2 = Integer.parseInt(filtered3);
			int min2 = Integer.parseInt(filtered4);

			if (hour > hour2) {
				faresOrdered = false;
				break;
			} else if (hour == hour2) {
				if (min > min2) {
					faresOrdered = false;
					break;
				}
			}
			System.out.print("Hour Fare Number " + i + ": " + hour + "  ");
			System.out.println("Min Fare Number " + i + ": " + min);

		}
		return faresOrdered;

	}

	public void setDepartureFlight(int fareNumber) {
		
		getWait().until(ExpectedConditions.invisibilityOf(progressBar));
		String selectFareBtn = "//li["+fareNumber+"]/div[2]/div//button";
		
		if(getDriver().findElements(By.xpath(selectFareBtn)).size() != 0) {
			WebElement selectThisFareBtn = getDriver().findElement(By.xpath(selectFareBtn));
			flightSelectBtn.get(fareNumber - 1).click();
			
			getWait().until(ExpectedConditions.visibilityOf(selectThisFareBtn));
			getWait().until(ExpectedConditions.elementToBeClickable(selectThisFareBtn));
			selectThisFareBtn.click();
		
				
		} else {
			flightSelectBtn.get(fareNumber - 1).click();
		}
		}

	public void setReturnFlight(int fareNumber) {
		getWait().until(
				ExpectedConditions.attributeContains(allFlights, "class", " price-sort"));
	
		String selectFareBtn = "//li[" + fareNumber + "]/div[2]/div//button";
		
		if (getDriver().findElements(By.xpath(selectFareBtn)).size() != 0) {
			WebElement selectThisFareBtn = getDriver().findElement(By.xpath(selectFareBtn));
			flightSelectBtn.get(fareNumber - 1).click();
			
			getWait().until(ExpectedConditions.visibilityOf(selectThisFareBtn));
			getWait().until(ExpectedConditions.elementToBeClickable(selectThisFareBtn));
			selectThisFareBtn.click();

		}else {

			flightSelectBtn.get(fareNumber - 1).click();
		}

		boolean modalPresent = getDriver().findElements(By.id("xSellHotelForcedChoice")).size() != 0;
		/*In here we handled if the add Hotel message is Displayed or not*/
		if (modalPresent) {
			WebElement noThanks = getDriver().findElement(By.id("forcedChoiceNoThanks"));
			getWait().until(ExpectedConditions.elementToBeClickable(noThanks));
			noThanks.click();
		} else {
			System.out.println("Modal Wasn't Displayed");
		}

		//return new FlightInformationPage(this.getDriver());
	}
}