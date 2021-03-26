package com.fw.assess.gui.testsuite;

import org.testng.annotations.Test;

import com.fw.assess.test.assertion.TestAssertions;

public class TC001 extends TestNgHooks {

	@Test
	public void test_login_task_with_valid_credentials() {		
		launchBrowser();
		open("http://leaftaps.com/opentaps");
		type(getWebElement("id=username"), "Demosalesmanager");
		type(getWebElement("id=password"), "crmsfa");
		click(getWebElement("classname=decorativeSubmit"));
		TestAssertions.verifyTheTest("CRM/SFA1", getText(getWebElement("xpath=//div[@id='label']/a")).trim());
		TestAssertions.assertTheTest("CRM/SFA", getText(getWebElement("xpath=//div[@id='label']/a")).trim());
		closeBrowser();
	}

}