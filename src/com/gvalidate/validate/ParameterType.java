/**
 * 
 */
package com.gvalidate.validate;

import com.gvalidate.utils.*;

/**
 * @author Gourav Kakkar
 *
 */
public class ParameterType {

	String regex;
	String length;
	String code;
	String message;
	
	protected ParameterType(String name){
		
		this.regex=PropertyUtils.getProperty(name+".regex");
		this.length=PropertyUtils.getProperty(name+".length");
		this.code=PropertyUtils.getProperty(name+".code");
		this.message=PropertyUtils.getProperty(name+".message");
	}
	
	
	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
