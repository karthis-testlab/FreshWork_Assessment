package com.fw.assess.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class JavaHelper {

	public static String generateRandomNumbers(int length) {
		String randomNumbers = RandomStringUtils.randomNumeric(length - 1);	
		return "6"+randomNumbers;
	}

	public static String generateRandomEmailId() {
		int rNum = Integer.parseInt(RandomStringUtils.randomNumeric(2)) + 151;
		String emailName = "username"+Integer.toString(rNum);
		String domainName = "email";
		return emailName+"@"+domainName+".com";
	}

	public static String extractString(String str, String regex) {
		return str.replaceAll(regex, "");
	}	

}