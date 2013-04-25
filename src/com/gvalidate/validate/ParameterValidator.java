package com.gvalidate.validate;

import java.util.Map;
import java.util.Map.Entry;
/**
 * @author Gourav Kakkar
 *
 */

public class ParameterValidator {

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
		
		ParameterType param=new ParameterType(key);
		if(!value.matches(param.regex))
		{
			// Failed Case
			throw new ValidationException(param);
		}
		else
			status=true;
		return status;
	}
}
