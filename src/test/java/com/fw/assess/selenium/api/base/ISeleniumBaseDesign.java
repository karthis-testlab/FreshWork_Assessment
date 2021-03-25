package com.fw.assess.selenium.api.base;

import java.util.List;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.fw.assess.constants.Browsers;
import com.fw.assess.utils.Logs;

import io.github.bonigarcia.wdm.WebDriverManager;

public interface ISeleniumBaseDesign {
	
	default RemoteWebDriver browser(String browserName) {
		RemoteWebDriver driver = null;
		Browsers browsers = Browsers.valueOf(browserName.toUpperCase());
		try {
			switch (browsers) {
			case CHROME:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();	
				Logs.consoleLog("PASS", "Successfully launched and maximized chrome browser");
				break;
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				Logs.consoleLog("PASS", "Successfully launched and maximized firefox browser");
			default:
				Logs.consoleLog("WARN", "Currently we're supporting chrome, and firefox browsers");
			}			
		} catch (WebDriverException e) {			
			Logs.consoleLog("FATAL", "The browser: "+browserName+" could not be launched");
		}		
		return driver;
	}
	
	public void closeBrowser();
	
	public void quitBrowser();
	
	public void open(String aut);
	
	public WebElement getWebElement(String locator);
	
	public List<WebElement> getWebElements(String locator);
	
	public void type(WebElement ele, String data);
	
	public void click(WebElement ele);
	
	public String getText(WebElement ele);
	
	public void selectValueInDropdown(WebElement ele, String text);
	
	public void moveToParticularElement(WebElement ele); 
	
	public void switchToWindow(int index);
	
	public void switchToFrame(WebElement ele);

}