package com.fw.assess.gui.testsuite;

import java.lang.reflect.Method;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.fw.assess.selenium.api.base.SeleniumBase;
import com.fw.assess.utils.Reporter;

public class TestNgHooks extends SeleniumBase {

	@BeforeSuite
	public void beforeSuite() {
		Reporter.createInstance("result");
	}

	@BeforeClass
	public void beforeClass() {
		Reporter.createTestCases(getClass().getName());		 
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		Reporter.createTest(method.getName());
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.tearDownInstance();
	}

}