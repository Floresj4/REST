package com.flores.projects.rest.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.PropertyConfigurator;
import org.glassfish.jersey.client.ClientConfig;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Only testing json.
 * @author Jason
 *
 */
public class TestServiceApi {

	public static final String BASE_URL = "http://localhost:8080/RESTfulWebService/resources/";

	private static ClientConfig config;
	private static Client client;
	private static WebTarget target;

	private static final Logger logger = LoggerFactory
			.getLogger(TestServiceApi.class);

	@BeforeClass
	public static void init() {
		//configure logging and target
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		config = new ClientConfig();
		client = ClientBuilder.newClient(config);
		target = client.target(UriBuilder.fromUri(BASE_URL).build());
	}

	//test users
	
	@Test
	public void getUserById() {
		String resource = "users/1";
		logger.info("Selecting user from {}", resource);
		String out = target.path(resource).request().accept(MediaType.APPLICATION_JSON).get(String.class);
		logger.debug(out);
		Assert.assertNotEquals(StringUtil.EMPTY_STRING_MSG, StringUtil.EMPTY_STRING, out);
	}
	
	@Test
	public void getUsers() {
		String resource = "users/";
		logger.debug("Selecting users from {}", resource);
		String out = target.path(resource).request().accept(MediaType.APPLICATION_JSON).get(String.class);
		logger.debug(out);
		Assert.assertNotEquals(StringUtil.EMPTY_STRING_MSG, StringUtil.EMPTY_STRING, out);
	}
	
	//test items

	@Test
	public void getItemById() {
		String resource = "items/1AB2C3";
		logger.info("Selecting item from {}", resource);
		String out = target.path(resource).request().accept(MediaType.APPLICATION_JSON).get(String.class);
		logger.debug(out);
		Assert.assertNotEquals(StringUtil.EMPTY_STRING_MSG, StringUtil.EMPTY_STRING, out);
	}
	
	@Test
	public void getItems() {
		String resource = "items/";
		logger.debug("Selecting items from {}", resource);
		String out = target.path(resource).request().accept(MediaType.APPLICATION_JSON).get(String.class);
		logger.debug(out);
		Assert.assertNotEquals(StringUtil.EMPTY_STRING_MSG, StringUtil.EMPTY_STRING, out);
	}
}