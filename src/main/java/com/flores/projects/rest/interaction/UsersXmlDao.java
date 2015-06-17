package com.flores.projects.rest.interaction;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flores.projects.rest.model.impl.User;

/**
 * Interaction class for user information obtained
 * from an XML file.
 * @author Jason
 */
public class UsersXmlDao implements IUsersDao {

	private static UsersXmlDao _instance = null;
	
	protected static Map<Integer, User> users;
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	
	private static final Logger logger = LoggerFactory.getLogger(UsersXmlDao.class);

	public static UsersXmlDao getInstance() {
		if(_instance == null)
			_instance = new UsersXmlDao();
		return _instance;
	}

	private UsersXmlDao() {
		try {
			//initialize data structure
			users = new HashMap<Integer, User>();

			//initialize a builder for our embedded resource
			SAXBuilder builder = new SAXBuilder();
			InputStream in = getClass().getClassLoader().getResourceAsStream("users.xml");

			//get document for build pojos
			Document document = (Document)builder.build(in);
			Element rootNode = document.getRootElement();
			for(Object child : rootNode.getChildren("user")) {
				User user = getUser((Element)child);
				users.put(user.getId(), user);
			}
		} 
		catch(JDOMException jde)
		{ logger.error("Error parsing users.xml: {}", jde.getMessage()); } 
		catch(IOException ioe)
		{ logger.error("Error loading users.xml: {}", ioe.getMessage()); }
	}

	/**
	 * Return all users
	 * @return a collection of users
	 */
	public Collection<User> getUsers() {
		return users.values();
	}

	/**
	 * get a user by id value
	 * @param id integer user id value
	 * @return a valid user or null
	 */
	public User getUser(int id) {
		return users.get(id);
	}
	
	public static User getUser(Element element) {
		User u = new User();
		u.setId(Integer.parseInt(element.getAttributeValue("id")));
		u.setFirstname(element.getChildText("firstname"));
		u.setLastname(element.getChildText("lastname"));
		u.setBio(element.getChildText("bio"));
		
		try { u.setBirthdate(dateFormat.parse(element.getChildText("birthdate"))); }
		catch(Exception e) { logger.error("Error parsing date: {}", e.getMessage()); }
		
		return u;
	}
}