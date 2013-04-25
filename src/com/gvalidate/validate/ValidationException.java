package com.gvalidate.validate;

public class ValidationException extends RuntimeException{
	/**
	 * @author Gourav Kakkar
	 *
	 */
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
