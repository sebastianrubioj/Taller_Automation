package com.globant.training.app.webAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MyDriver {
	
	private WebDriver mDriver;

    public MyDriver(String browser){
        //String seleniumUrl = "http://localhost:4444/wd/hub";
        switch (browser){
            /*case "remoteFirefox":
                try{
                    mDriver = new RemoteWebDriver(new URL(seleniumUrl), new FirefoxOptions());
                }catch(MalformedURLException e){
                    e.printStackTrace();
                }
                break;
            case "remoteChrome":
                try {
                    mDriver = new RemoteWebDriver(new URL(seleniumUrl), new ChromeOptions());
                } catch(MalformedURLException e){
                    e.printStackTrace();
                }
                break;*/
            case "firefox":
                System.setProperty("webdriver.gecko.driver","./res/geckodriver.exe");
                mDriver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver","./res/chromedriver.exe");
                mDriver = new ChromeDriver();
                break;
            default:
                break;
        }
    }

    public WebDriver getDriver(){
        return this.mDriver;
    }
}
