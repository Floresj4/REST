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
import com.flores.projects.rest.resource.IUsersDao;
import com.flores.projects.rest.resource.UsersXmlDao;

/**
 * Root resource class for users.
 *  
 * Object supports JSON and XML thru MOXy
 * @author Jason
 *
 */
@Path("/users")
public class UsersResource {

	@Context
	private UriInfo uriInfo;

	private IUsersDao userInteraction;
	
	/**
	 * for server-side logging
	 */
	private static final Logger logger = LoggerFactory.getLogger(UsersResource.class);

	public UsersResource() {
		userInteraction = UsersXmlDao.getInstance();
	}

	@GET @Path("{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public User getUserObject(@PathParam("id") String id) {
		logger.debug("getUserObject id {}", id);
		return userInteraction.getUser(Integer.parseInt(id));
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Collection<User> getUsers() {
		logger.debug("getUsers");
		return userInteraction.getUsers();
	}
}