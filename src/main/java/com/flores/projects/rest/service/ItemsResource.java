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

import com.flores.projects.rest.model.Item;
import com.flores.projects.rest.resource.ItemsDao;

/**
 * Root resource class for items
 * 
 * Object supports JSON and XML thru MOXy
 * @author Jason
 * 
 */
@Path("/items")
public class ItemsResource {

	@Context
	private UriInfo uriInfo;
	
	/**
	 * for server-side logging
	 */
	private static final Logger logger = LoggerFactory.getLogger(ItemsResource.class);
	
	public ItemsResource() { }
	
	@GET @Path("{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Item getItemObject(@PathParam("id") String id) {
		logger.debug("getItemObject id {}", id);
		Item i = ItemsDao.getItem(id);
		System.out.println(i);
		logger.debug("{}",i);
		return i;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Collection<Item> getItems() {
		logger.debug("getItems");
		return ItemsDao.getItems();
	}
}
