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

import com.globant.training.app.pages.travelocity.CarSearchPage;
import com.globant.training.app.pages.travelocity.ChooseARoomPage;
import com.globant.training.app.pages.travelocity.FlightCheckoutPage;
import com.globant.training.app.pages.travelocity.FlightInformationPage;
import com.globant.training.app.pages.travelocity.FlightSearchPage;
import com.globant.training.app.pages.travelocity.HomePage;
import com.globant.training.app.pages.travelocity.HotelSearchPage;


public class BaseTest {
    private MyDriver myDriver;
    private HomePage homePage;
    private FlightSearchPage selectPage;
    private FlightInformationPage informationPage;
    private FlightCheckoutPage checkoutPage;
    private HotelSearchPage hotelSearchPage;
    private ChooseARoomPage chooseARoomPage;
    private CarSearchPage carSearchPage;
    
  
    @BeforeMethod (alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser){
        myDriver = new MyDriver(browser);
        homePage = new HomePage(myDriver.getDriver());
        informationPage = new FlightInformationPage(myDriver.getDriver());
        carSearchPage = new CarSearchPage(myDriver.getDriver());
    }

  @AfterMethod (alwaysRun = true)
    public void afterSuite(){
        myDriver.getDriver().quit();
    }
 
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
    
    public HotelSearchPage getHotelSearchPage() {
    	return this.hotelSearchPage;
    }
    
    public ChooseARoomPage getChooseARoomPage(){
    	return this.chooseARoomPage;
    }
    
    public CarSearchPage getCarSearchPage() {
    	return this.carSearchPage;
    }
}