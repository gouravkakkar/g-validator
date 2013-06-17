package com.gvalidate.validate;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.gvalidate.utils.PropertyUtils;
/**
 * @author Gourav Kakkar
 *
 */

public class ParameterValidator {
	
	private static final Logger logger = Logger.getLogger(ParameterValidator.class
			.getName());
	

	public static boolean validate(Map<String,String> m){
		
		boolean status = false; 
		
		for(Entry<String,String> entry: m.entrySet()){
			status = validate(entry.getKey(),entry.getValue());
			 if(!status)
				  break;
		}
		return status;
		
	}
	
	public static boolean validate(String key, String value) {
		
		boolean status=false;
		String checkForPresence=PropertyUtils.getProperty(key+".regex");
		if(checkForPresence!=null){
			ParameterType param=new ParameterType(key);
			logger.log(Level.INFO, "Validating "+key+" against "+param.regex);
			if(!value.matches(param.regex))
			{
				// Failed Case
				logger.log(Level.INFO, "Validation failed for "+key+" against "+param.regex);
				throw new ValidationException(param);
			}
			else
				status=true;	
		}else
		{
			//Validate against Default values
			ParameterType param=new ParameterType("Default");
			logger.log(Level.INFO, "Validating "+key+" against Default value="+param.regex);
			if(!value.matches(param.regex))
			{
				// Failed Case
				logger.log(Level.INFO, "Validation failed for "+key+" against "+param.regex);
				throw new ValidationException(param);
			}
			else
				status=true;
		}
		
		
		
		return status;
	}
	
	public static boolean validate(HttpServletRequest request){
		boolean status=false;
		Map<String,String[]> requestParameterMap = new HashMap<String, String[]>(request.getParameterMap());
		for (Entry<String, String[]> entry : requestParameterMap.entrySet()) {
		  status=validate(entry.getKey(),  entry.getValue());
		  if(!status)
		  break;
		}
		
		return status;		
	}
	
	private static boolean validate(String key, String[] value) {
		// TODO Loop on all values and check for validation of each.
		return ParameterValidator.validate(key, value[0]);
	}
}
