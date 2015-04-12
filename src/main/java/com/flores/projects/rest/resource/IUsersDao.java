package com.flores.projects.rest.resource;

import java.util.Collection;

import com.flores.projects.rest.model.User;

/**
 * 
 * @author Jason
 */
public interface IUsersDao {
	public Collection<User> getUsers();
	public User getUser(int id);
}
