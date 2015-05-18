package com.flores.projects.rest.app;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Alternate application configuration using ResourceConfig
 * as the Application model.
 * 
 * @author Jason
 */
public class UserApplication extends ResourceConfig {
	public UserApplication() {
		packages("com.flores.projects.rest.service");
	}
}
