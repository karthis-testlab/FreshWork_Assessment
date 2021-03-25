package com.fw.assess.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {
	
	private static Logger logger = LogManager.getLogger(Logs.class);

	public static void consoleLog(String status, String content) {
		if(status.equalsIgnoreCase("PASS")) {			
			logger.info("[PASSED]: "+ content);
		} else if(status.equalsIgnoreCase("FAIL")) {
			logger.error("[FAILED]: "+ content);						
		} else if(status.equalsIgnoreCase("WARN")) {
			logger.warn("[WARNING]: "+ content);			
		} else if(status.equalsIgnoreCase("FATAL")) {
			logger.fatal("[FAILED]: "+ content);
			throw new RuntimeException("[FAILED]: "+ content);
		}
	}

}