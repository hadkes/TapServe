package edu.tcd.tapserve.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class ApplicationSecurityConfigurationInitializer extends AbstractSecurityWebApplicationInitializer {
	// Default constructor
	public ApplicationSecurityConfigurationInitializer() {
        super(ApplicationSecurityConfiguration.class);
    }
	
	//empty body, do nothing, it will automatically add filters and load security configuration class
}
