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
	
	@FindBy(id=SORT_BAR)
	private WebElement sortBar;
	
	@FindAll({@FindBy(css=SELECT_CAR_BTN_LIST)})
	private List<WebElement> selectCarButtonList;
	
	public CarSearchPage(WebDriver pDriver) {
		super(pDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void setCarToRent(int carOptionNumber) {
		getWait().until(ExpectedConditions.visibilityOf(sortBar));
		selectCarButtonList.get(carOptionNumber-1).click();
	}

}
