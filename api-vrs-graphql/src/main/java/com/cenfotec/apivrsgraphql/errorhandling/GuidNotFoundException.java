package com.cenfotec.apivrsgraphql.errorhandling;


public class GuidNotFoundException extends Exception {
	
	public GuidNotFoundException() {
		super();
	}
	
	public GuidNotFoundException(final String message) {
        super(message);
    }

}
