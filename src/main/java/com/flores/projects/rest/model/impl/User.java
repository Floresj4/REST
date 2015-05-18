package com.flores.projects.rest.model.impl;

import java.util.Date;

import com.flores.projects.rest.model.IUser;

/**
 * Simple user object
 * @author Jason
 *
 */
public class User implements IUser {
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String firstname;
	private String lastname;
	private String uri;
	private String bio;

	private Date birthdate;
	
	public User() {}
	
	public User(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getBio() {
		return bio;
	}

	public String getFirstname() {
		return firstname;
	}

	public int getId() {
		return id;
	}

	public String getLastname() {
		return lastname;
	}
	
	public String getUri() {
		return uri;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
}
