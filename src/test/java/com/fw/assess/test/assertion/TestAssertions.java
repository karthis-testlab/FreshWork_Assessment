package com.fw.assess.test.assertion;

import org.testng.Assert;

import com.fw.assess.utils.Logs;
import com.fw.assess.utils.Reporter;

public class TestAssertions {
	
	public static void verifyTheTest(String eValue, String aValue) {
		if(eValue.equals(aValue)) {
			Reporter.reportLog("PASS", "Expeted value <"+eValue+"> matches with the actual one <"+aValue+">");
			Logs.consoleLog("PASS", "Expeted value <"+eValue+"> matches with the actual one <"+aValue+">");
		} else {
			Reporter.reportLog("FAIL", "Expeted value ["+eValue+"] not matched with the actual one ["+aValue+"]");
			Logs.consoleLog("FAIL", "Expeted value <"+eValue+"> not matched with the actual one <"+aValue+">");
		}
	}
	
	public static void assertTheTest(String eValue, String aValue) {
		try {
			Assert.assertEquals(eValue, aValue);
			Reporter.reportLog("PASS", "Expeted value <"+eValue+"> matches with the actual one <"+aValue+">");
			Logs.consoleLog("PASS", "Expeted value <"+eValue+"> matches with the actual one <"+aValue+">");
		} catch (AssertionError e) {			
			Reporter.reportLog("FATAL", "Expeted value ["+eValue+"] not matched with the actual one ["+aValue+"] "+e.toString());
			Logs.consoleLog("FATAL", "Expeted value <"+eValue+"> not matched with the actual one <"+aValue+"> "+e.toString());
		}
	}

}