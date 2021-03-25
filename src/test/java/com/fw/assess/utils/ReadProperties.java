package com.fw.assess.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	public static String readObjectRepositories(String fileName, String key) {		
		Properties prop = new Properties();
		String value = null;
		try {
			FileReader file = new FileReader(new File("src/test/resources/ObjectRepositories/"+fileName+".properties"));
			prop.load(file);
			value = prop.getProperty(key);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return value;
	}
	
	public static String readConfig(String key) {		
		Properties prop = new Properties();
		String value = null;
		try {
			FileReader file = new FileReader(new File("src/test/resources/ObjectRepositories/Config.properties"));
			prop.load(file);
			value = prop.getProperty(key);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return value;
	}

}