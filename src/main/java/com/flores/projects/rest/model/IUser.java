package com.flores.projects.rest.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Interface defining the contract for User implementations for this application.  In
 * a real-world scenario this contract could be defined outside of the service.  This
 * approach allows the separation of simples pojos from beans which might be heavily
 * annotated in a web-service domain.
 * 
 * @author Jason
 */
public interface IUser extends Serializable {

	public String getBio();
	
	public Date getBirthdate();
	
	public String getFirstname();
	
	public int getId();
	
	public String getLastname();

	public void setBio(String bio);

	public void setBirthdate(Date birthdate);

	public void setFirstname(String firstname);

	public void setId(int id);

	public void setLastname(String lastname);
}
