package com.globant.training.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    protected BasePage(WebDriver pDriver){
        PageFactory.initElements(pDriver,this);
        int timeout = 20;
        wait = new WebDriverWait(pDriver, timeout);
        driver = pDriver;
        actions = new Actions(driver);
    }

    protected WebDriver getDriver(){
        return driver;
    }

    protected WebDriverWait getWait() {
        return wait;
    }

    public Actions getActions() {
        return actions;
    }

    public void dispose(){
        if(driver != null){
            driver.quit();
        }
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
