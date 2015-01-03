package com.flores.projects.rest.service;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flores.projects.rest.model.User;
import com.flores.projects.rest.resource.UsersDao;

/**
 * Root resource class for users.
 * 
 * A common application pattern is to use POST to create a resource 
 * and return a 201 response with a location header whose value is 
 * the URI to the newly created resource. In this pattern, the web 
 * service declares the URI for the newly created resource
 * 
 * Object supports JSON and XML thru MOXy and {@linkplain javax.ws.rs.core.Response}
 * @author Jason
 *
 */
@Path("/users")
public class UsersResource {

	@Context
	private UriInfo uriInfo;

	/**
	 * for server-side logging
	 */
	private static final Logger logger = LoggerFactory.getLogger(UsersResource.class);

	public UsersResource() { }

	@GET @Path("{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public User getUserObject(@PathParam("id") String id) {
		logger.debug("getUserObject id {}", id);
		return UsersDao.getUser(id);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Collection<User> getUsers() {
		logger.debug("getUsers");
		return UsersDao.getUsers();
	}
}
