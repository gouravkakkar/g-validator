package com.gvalidate.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * @author Gourav Kakkar
 *
 */
public class PropertyUtils {

	 static Properties instance=getInstance();
	
	   private static Properties getInstance() {
	      instance = new Properties();
	      try {
			instance.load(PropertyUtils.class.getClassLoader().getResourceAsStream("g-validate.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return instance;
	   }
	   
	   public static String getProperty(String name) {
		return instance.getProperty(name).trim();
		    }
	   
}
