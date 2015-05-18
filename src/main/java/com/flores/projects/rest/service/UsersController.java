package com.flores.projects.rest.service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flores.projects.rest.interaction.IUsersDao;
import com.flores.projects.rest.interaction.UsersXmlDao;
import com.flores.projects.rest.model.impl.User;
import com.flores.projects.rest.resource.UserResource;

/**
 * Root resource class for users.
 *  
 * Object supports JSON and XML thru MOXy
 * @author Jason
 *
 */
@Path("/users")
public class UsersController {

	@Context
	private UriInfo uriInfo;

	private IUsersDao userInteraction;
	
	private List<Link> links = new LinkedList<>();
	
	@XmlJavaTypeAdapter(Link.JaxbAdapter.class)
	public List<Link> getLinks() {
		return links;
	}
	 
	/**
	 * for server-side logging
	 */
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

	public UsersController() {
		userInteraction = UsersXmlDao.getInstance();
	}

	@GET @Path("{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public UserResource getUserObject(@PathParam("id") String id) {
		logger.debug("getUserObject id {}", id);
		return new UserResource(userInteraction.getUser(Integer.parseInt(id)), uriInfo);
	}
	
	@GET @Path("")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Collection<User> getUsers() {
		logger.debug("getUsers");
		return userInteraction.getUsers();
	}
}