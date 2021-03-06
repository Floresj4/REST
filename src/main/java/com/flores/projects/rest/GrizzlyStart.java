package com.flores.projects.rest;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import com.flores.projects.rest.app.UserApplication;

/**
 * 
 * @author Jason
 */
public class GrizzlyStart {
	public static void main(String args[]) throws IOException, InterruptedException {
		int port = Integer.parseInt(System.getenv("PORT") == null ? "15351" : System.getenv("PORT"));
		URI baseUri = UriBuilder.fromUri("http://localhost").port(port).build();

		System.out.println("Starting Grizzly...");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, new UserApplication());
		server.start();	//how will heroku deal with shutdown?
	}
}