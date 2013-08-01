/**
 * Copyright (c) 2013 Gourav Kakkar<gouravkakkar@gmail.com>
 * See the file license.txt for copying permission.
 */

package com.gvalidate.validate;

public class ValidationException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	String code;
	String message;
	
	public ValidationException(ParameterType param){
		this.code=param.code;
		this.message=param.message;
	}
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	
}
