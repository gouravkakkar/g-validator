g-validator
===========

A wrapper layer over web-application for validation of request parameters and creating associated error codes for each failed validation.

Installation
===========

You need g-validate.properties file on your classpath. It is provided with the source package. This file servers as a medium of input to the validation framework.

Sample Usage
===========

    
    try{
			
      ParameterValidator.validate(request);
      // Pass the HttpRequest object to the framework for validation. 
      // It will validate all the params against the Regex'd defined in g-validate.properties file.
      
			}
			catch(ValidationException e){
				
				//Use inbuilt methods like e.getCode(),e.getMessage() for generating your custom response.
        
			}
