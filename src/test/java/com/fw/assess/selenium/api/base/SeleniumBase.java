package com.fw.assess.selenium.api.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.fw.assess.constants.LocatorTypes;
import com.fw.assess.utils.Logs;
import com.fw.assess.utils.Reporter;

public class SeleniumBase implements ISeleniumBaseDesign {
	
	private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
	public RemoteWebDriver getDriver() {
		return driver.get();
	}
	
	public void launchBrowser() {
		driver.set(browser("CHROME"));		
	}
	
	public void closeBrowser() {
		getDriver().close();		
	}
	
	public void quitBrowser() {
		getDriver().quit();		
	}

	public void open(String aut) {
		try {
			getDriver().get(aut);	
			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Reporter.reportLog("PASS", "Opened given aut url in the "+getDriver()+" opened browser with 30sec implicit wait time");
			Logs.consoleLog("PASS", "Opened given aut url in the "+getDriver()+" opened browser with 30sec implicit wait time");
		} catch (Exception e) {			
			Logs.consoleLog("FATAL", "Unable to load given aut url in the "+getDriver()+" opened browser within 30sec implicit wait time. Because of "+e.toString());
		}
	}

	public WebElement getWebElement(String locator) {		
		WebElement element = null;
		String[] ele = locator.split("=", 2);		
		String key = ele[0];		
		String value = ele[1];		
		LocatorTypes loc = LocatorTypes.valueOf(key.toUpperCase());
		try {
			switch (loc) {
			case ID:
				element = getDriver().findElementById(value);	
				Reporter.reportLog("PASS", "Successfully get webelement "+element+" from the DOM using locator type us ID");
				Logs.consoleLog("PASS", "Successfully get webelement "+element+" from the DOM using locator type us ID");
				break;
			case NAME:
				element = getDriver().findElementByName(value);
				Reporter.reportLog("PASS", "Successfully get webelement "+element+" from the DOM using locator type us NAME");
				Logs.consoleLog("PASS", "Successfully get webelement "+element+" from the DOM using locator type us NAME");
				break;
			case CLASSNAME:
				element = getDriver().findElementByClassName(value);
				Reporter.reportLog("PASS", "Successfully get webelement "+element+" from the DOM using locator type us CLASSNAME");
				Logs.consoleLog("PASS", "Successfully get webelement "+element+" from the DOM using locator type us CLASSNAME");
				break;
			case LINKTEXT:
				element = getDriver().findElementByLinkText(value);
				Reporter.reportLog("PASS", "Successfully get webelement "+element+" from the DOM using locator type us LINKTEXT");
				Logs.consoleLog("PASS", "Successfully get webelement "+element+" from the DOM using locator type us LINKTEXT");
				break;
			case PARTIALLINKTEXT: 	
				element = getDriver().findElementByPartialLinkText(value);
				Reporter.reportLog("PASS", "Successfully get webelement "+element+" from the DOM using locator type us PARTIALLINKTEXT");
				Logs.consoleLog("PASS", "Successfully get webelement "+element+" from the DOM using locator type us PARTIALLINKTEXT");
				break;
			case TAGNAME:
				element = getDriver().findElementByTagName(value);
				Reporter.reportLog("PASS", "Successfully get webelement "+element+" from the DOM using locator type us TAGNAME");
				Logs.consoleLog("PASS", "Successfully get webelement "+element+" from the DOM using locator type us TAGNAME");
				break;
			case CSSSELECTOR:
				element = getDriver().findElementByCssSelector(value);
				Reporter.reportLog("PASS", "Successfully get webelement "+element+" from the DOM using locator type us CSSSELECTOR");
				Logs.consoleLog("PASS", "Successfully get webelement "+element+" from the DOM using locator type us CSSSELECTOR");
				break;
			case XPATH:
				element = getDriver().findElementByXPath(value);
				Reporter.reportLog("PASS", "Successfully get webelement "+element+" from the DOM using locator type us XPATH");
				Logs.consoleLog("PASS", "Successfully get webelement "+element+" from the DOM using locator type us XPATH");
				break;
			default:
				Reporter.reportLog("FAIL", "Selenium supports only following locators ID, NAME, CLASSNAME, LINKTEXT, PARTIALLINKTEXT, TAGNAME, CSSSELECTOR and XPATH. Kindly check your locator type in object repository.");
				Logs.consoleLog("WARN", "Selenium supports only following locators ID, NAME, CLASSNAME, LINKTEXT, PARTIALLINKTEXT, TAGNAME, CSSSELECTOR and XPATH. Kindly check your locator type in object repository.");
			}
		} catch (Exception e) {		
			Reporter.reportLog("FAIL", "Unable to get webelement "+element+" from the DOM. Because of "+e.toString());
			Logs.consoleLog("FATAL", "Unable to get webelement "+element+" from the DOM. Because of "+e.toString());
		}		
		return element;
	}

	public List<WebElement> getWebElements(String locator) {
		List<WebElement> elements = null;
		String[] eles = locator.split("=", 2);
		String key = eles[0];
		String value = eles[1];	
		LocatorTypes loc = LocatorTypes.valueOf(key.toUpperCase());
		try {
			switch (loc) {
			case ID:
				elements = getDriver().findElementsById(value);
				Reporter.reportLog("PASS", "Successfully get list of webelements "+elements+" from the DOM using locator type us ID");
				Logs.consoleLog("PASS", "Successfully get list of webelements "+elements+" from the DOM using locator type us ID");
				break;
			case NAME:
				elements = getDriver().findElementsByName(value);
				Reporter.reportLog("PASS", "Successfully get list of webelements "+elements+" from the DOM using locator type us NAME");
				Logs.consoleLog("PASS", "Successfully get list of webelements "+elements+" from the DOM using locator type us NAME");
				break;
			case CLASSNAME:
				elements = getDriver().findElementsByClassName(value);
				Reporter.reportLog("PASS", "Successfully get list of webelements "+elements+" from the DOM using locator type us CLASSNAME");
				Logs.consoleLog("PASS", "Successfully get list of webelements "+elements+" from the DOM using locator type us CLASSNAME");
				break;
			case LINKTEXT:
				elements = getDriver().findElementsByLinkText(value);
				Reporter.reportLog("PASS", "Successfully get list of webelements "+elements+" from the DOM using locator type us LINKTEXT");
				Logs.consoleLog("PASS", "Successfully get list of webelements "+elements+" from the DOM using locator type us LINKTEXT");
				break;
			case PARTIALLINKTEXT: 	
				elements = getDriver().findElementsByPartialLinkText(value);
				Reporter.reportLog("PASS", "Successfully get list of webelements "+elements+" from the DOM using locator type us PARTIALLINKTEXT");
				Logs.consoleLog("PASS", "Successfully get list of webelements "+elements+" from the DOM using locator type us PARTIALLINKTEXT");
				break;
			case TAGNAME:
				elements = getDriver().findElementsByTagName(value);
				Reporter.reportLog("PASS", "Successfully get list of webelements "+elements+" from the DOM using locator type us TAGNAME");
				Logs.consoleLog("PASS", "Successfully get list of webelements "+elements+" from the DOM using locator type us TAGNAME");
				break;
			case CSSSELECTOR:
				elements = getDriver().findElementsByCssSelector(value);
				Reporter.reportLog("PASS", "Successfully get list of webelements "+elements+" from the DOM using locator type us CSSSELECTOR");
				Logs.consoleLog("PASS", "Successfully get list of webelements "+elements+" from the DOM using locator type us CSSSELECTOR");
				break;
			case XPATH:
				elements = getDriver().findElementsByXPath(value);
				Reporter.reportLog("PASS", "Successfully get list of webelements "+elements+" from the DOM using locator type us XPATH");
				Logs.consoleLog("PASS", "Successfully get list of webelements "+elements+" from the DOM using locator type us XPATH");
				break;
			default:
				Reporter.reportLog("FAIL", "Selenium supports only following locators ID, NAME, CLASSNAME, LINKTEXT, PARTIALLINKTEXT, TAGNAME, CSSSELECTOR and XPATH. Kindly check your locator type in object repository.");
				Logs.consoleLog("WARN", "Selenium supports only following locators ID, NAME, CLASSNAME, LINKTEXT, PARTIALLINKTEXT, TAGNAME, CSSSELECTOR and XPATH. Kindly check your locator type in object repository.");	
			}
		} catch (Exception e) {		
			Reporter.reportLog("FAIL", "Unable to get webelement "+elements+" from the DOM. Because of "+e.toString());
			Logs.consoleLog("FATAL", "Unable to get list of webelements "+elements+" from the DOM. Because of "+e.toString());
		}		
		return elements;
	}
	
	public void type(WebElement ele, String data) {	
		try {			
			ele.sendKeys(data);
			Reporter.reportLog("PASS", "Successfully type the given data "+data+" in the given element "+ele+" in the DOM");
			Logs.consoleLog("PASS", "Successfully type the given data "+data+" in the given element "+ele+" in the DOM");
		} catch (InvalidElementStateException e) {
			Logs.consoleLog("FATAL", "The data: "+data+" could not be entered in the field : "+ele);
		} catch (WebDriverException e) {
			Logs.consoleLog("FATAL", "Unknown exception occured while entering "+data+" in the field : "+ele);
		} catch (Exception e) {			
			Logs.consoleLog("FATAL", "Unable to type the given data "+data+" in the given element "+ele+" in the DOM. Beacuse of "+e.toString());
		}		
	}

	public void click(WebElement ele) {
		try {			
			ele.click();
			Reporter.reportLog("PASS", "Successfully click on the given element "+ele+" in the DOM");
			Logs.consoleLog("PASS", "Successfully click on the given element "+ele+" in the DOM");
		} catch (Exception e) {		
			Reporter.reportLog("FAIL", "Unable to click on the given element "+ele+" in the DOM. Beacuse of "+e.toString());
			Logs.consoleLog("FATAL", "Unable to click on the given element "+ele+" in the DOM. Beacuse of "+e.toString());
		}		
	}

	public String getText(WebElement ele) {
		String text = null;
		try {			
			text = ele.getText();
			Reporter.reportLog("PASS", "Successfully fetch the following text "+text+" from the given element "+ele+" in the DOM");
			Logs.consoleLog("PASS", "Successfully fetch the following text "+text+" from the given element "+ele+" in the DOM");
		} catch (Exception e) {	
			Reporter.reportLog("FAIL", "Unable to fetch the following text "+text+" from the given element "+ele+" in the DOM. Because of "+e.toString());
			Logs.consoleLog("FATAL", "Unable to fetch the following text "+text+" from the given element "+ele+" in the DOM. Because of "+e.toString());
		}
		return text;
	}

	public void selectValueInDropdown(WebElement ele, String text) {
		try {
			Select select = new Select(ele);
			select.selectByVisibleText(text);
			Reporter.reportLog("PASS", "Successfully select the given visible text "+text+" from the given element "+ele+" in the DOM");
			Logs.consoleLog("PASS", "Successfully select the given visible text "+text+" from the given element "+ele+" in the DOM");
		} catch (Exception e) {
			Reporter.reportLog("FAIL", "Unable to select the given visible text "+text+" from the given element "+ele+" in the DOM "+e.getMessage());
			Logs.consoleLog("FATAL", "Unable to select the given visible text "+text+" from the given element "+ele+" in the DOM "+e.getMessage());			
		}
	}
	
	public void moveToParticularElement(WebElement ele) {
		try {
			Actions action = new Actions(getDriver());
			action.moveToElement(ele).perform();
			Reporter.reportLog("PASS", "Successfully moved to the given element "+ele+" in the DOM");
			Logs.consoleLog("PASS", "Successfully moved to the given element "+ele+" in the DOM");
		} catch (Exception e) {	
			Reporter.reportLog("FAIL", "Unable to move to the given element "+ele+" in the DOM "+e.getMessage());
			Logs.consoleLog("FATAL", "Unable to move to the given element "+ele+" in the DOM "+e.getMessage());
		}
	}
	
	public void switchToWindow(int index) {
		ArrayList<String> window = null;
		try {
			window = new ArrayList<String>(getDriver().getWindowHandles());
			getDriver().switchTo().window(window.get(index));
			Reporter.reportLog("PASS", "Successfully switched into the window "+window.get(index));
			Logs.consoleLog("PASS", "Successfully switched into the window "+window.get(index));
		} catch (Exception e) {		
			Reporter.reportLog("FAIL", "Unable to moved into the "+window.get(index)+" given window "+e.getMessage());
			Logs.consoleLog("FATAL", "Unable to moved into the "+window.get(index)+" given window "+e.getMessage());
		}
	}
	
	public void switchToFrame(WebElement ele) {		
		try {
			getDriver().switchTo().frame(ele);
			Reporter.reportLog("PASS", "Successfully switched into the frame "+ele);
			Logs.consoleLog("PASS", "Successfully switched into the frame "+ele);
		} catch (Exception e) {	
			Reporter.reportLog("FAIL", "Unable to moved into the "+ele+" given frame "+e.getMessage());
			Logs.consoleLog("FATAL", "Unable to moved into the "+ele+" given frame "+e.getMessage());
		}
	}
	
	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(getDriver().getScreenshotAs(OutputType.FILE) , new File("src/test/resources/Reports/Images/"+number+".png"));
			Logs.consoleLog("PASS", "Successfully to took the screen shot and stored into the following path src/test/resources/Reports/Images/");
		} catch (WebDriverException e) {
			Logs.consoleLog("FAIL", "Unable to took the screen shot and stored into the following path src/test/resources/Reports/Images/");
		} catch (IOException e) {
			Logs.consoleLog("FAIL", "Kindly check the following folder was available or not - 'src/test/resources/Reports/Images/'");
		}
		return number;
	}
	

}