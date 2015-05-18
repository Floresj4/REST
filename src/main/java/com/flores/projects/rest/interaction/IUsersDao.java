package com.flores.projects.rest.interaction;

import java.util.Collection;

import com.flores.projects.rest.model.impl.User;

/**
 * 
 * @author Jason
 */
public interface IUsersDao {
	public Collection<User> getUsers();
	public User getUser(int id);
}
