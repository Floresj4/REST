package com.flores.projects.rest.resource;

import java.util.Date;

import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flores.projects.rest.model.IUser;
import com.flores.projects.rest.model.impl.User;
import com.flores.projects.rest.service.UsersController;

/**
 * User resource used to interact with HTTP-verbs PUT, POST, GET, and DELETE.
 * This class implements the IUser interface solely to provide annotations
 * and business logic to facilitate hypermedia requests.
 * 
 * @author Jason
 */
@XmlRootElement(name = "user")
@XmlType(propOrder = {"firstname", "lastname", "birthdate", "bio", "link"})
public class UserResource implements IUser {
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String firstname;
	private String lastname;
	private String bio;
	
	private Date birthdate;
	
	private Link link;
	
	/**
	 * No arg constructor required by JAX-B
	 */
	public UserResource() { }
	
	public UserResource(User user, UriInfo uriInfo) {
//		this.user = user;
		this.link = Link.fromUriBuilder(uriInfo.getBaseUriBuilder()
				.path(UsersController.class, "getUsers"))
				.rel("users")
				.build(user.getId());
	}
	
	@XmlElement(name = "bio")
	public String getBio() {
		return bio;
	}
	
	@XmlElement(name = "birthdate")
	public Date getBirthdate() {
		return birthdate;
	}
	
	@XmlElement(name = "firstname")
	public String getFirstname() {
		return firstname;
	}
	
	@XmlAttribute
	public int getId() {
		return id;
	}
	
	@XmlElement(name = "lastname")
	public String getLastname() {
		return lastname;
	}
	
	@XmlElement(name = "link")
	@XmlJavaTypeAdapter(Link.JaxbAdapter.class)
	public Link getLink() {
		return link;
	}

	@Override
	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}