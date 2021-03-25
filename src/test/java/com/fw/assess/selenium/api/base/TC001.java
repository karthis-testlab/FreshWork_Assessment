package com.fw.assess.selenium.api.base;

import org.testng.annotations.Test;

public class TC001 extends TestNgHooks {

	@Test
	public void test_login_task_with_valid_credentials() {		
		launchBrowser();
		open("http://leaftaps.com/opentaps");
		type(getWebElement("id=username"), "Demosalesmanager");
		type(getWebElement("id=password"), "crmsfa");
		click(getWebElement("classname=decorativeSubmit"));
		closeBrowser();
	}

}