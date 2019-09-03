package com.globant.training.app.webAutomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.globant.training.app.pages.travelocity.FlightCheckoutPage;
import com.globant.training.app.pages.travelocity.FlightInformationPage;
import com.globant.training.app.pages.travelocity.FlightSearchPage;
import com.globant.training.app.pages.travelocity.HomePage;


public class BaseTest {
    private MyDriver myDriver;
    private HomePage homePage;
    private FlightSearchPage selectPage;
    private FlightInformationPage informationPage;
    private FlightCheckoutPage checkoutPage;
    
   // @BeforeTest(alwaysRun = true)
    @BeforeMethod (alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser){
        myDriver = new MyDriver(browser);
        homePage = new HomePage(myDriver.getDriver());
       /* selectPage = new FlightSearchPage(myDriver.getDriver());
        informationPage = new FlightInformationPage(myDriver.getDriver());
        checkoutPage = new FlightCheckoutPage (myDriver.getDriver());*/
    }

   //@AfterTest(alwaysRun = true)
 /*   @AfterMethod (alwaysRun = true)
    public void afterSuite(){
        myDriver.getDriver().quit();
    }*/
    
    public HomePage getHomePage() {
    	return this.homePage;
    }
    
    public FlightSearchPage getSelectPage() {
    	return this.selectPage;
    }
    
    public FlightInformationPage getInformationPage() {
    	return this.informationPage;
    }
    
    public FlightCheckoutPage getCheckoutPage() {
    	return this.checkoutPage;
    }
}