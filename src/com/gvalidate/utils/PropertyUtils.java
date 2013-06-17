package com.gvalidate.utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Gourav Kakkar
 * 
 */
public class PropertyUtils {

	static Properties instance = getInstance();
	private static final Logger logger = Logger.getLogger(PropertyUtils.class
			.getName());

	private static Properties getInstance() {
		try {
			instance = new Properties();
			instance.load(PropertyUtils.class.getClassLoader()
					.getResourceAsStream("g-validate.properties"));
			return instance;
		} catch (Exception e) {
			logger.log(Level.CONFIG, "Problem locating 'g-validate.properties' file. Please add the file on classpath.");
		}
		return instance;

	}

	public static String getProperty(String name) {

		try {
			return instance.getProperty(name).trim();
		} catch (NullPointerException e) {
			logger.log(Level.INFO, "No entity found for "+name+" in g-validate.properties file.");
		}
		return null;
	}

}
