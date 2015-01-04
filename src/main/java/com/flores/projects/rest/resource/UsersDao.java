package com.flores.projects.rest.resource;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.flores.projects.rest.model.User;

/**
 * static class used to interact with users
 * @author Jason
 *
 */
public class UsersDao {
	
	protected static Map<String, User> users;
	static {
		users = new LinkedHashMap<String, User>() {
			private static final long serialVersionUID = 1L; {
				put("1", new User("Kevin", "Hart"));
				put("2", new User("Russell", "Peters"));
				put("3", new User("Terrance", "Burke"));
			}
		};	
	}
	
	/**
	 * Return all users
	 * @return
	 */
	public static Collection<User> getUsers() {
		return users.values();
	}
	
	/**
	 * get a user by id value
	 * @param id
	 * @return
	 */
	public static User getUser(String id) {
		return users.get(id);
	}
}