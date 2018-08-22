package com.restEasy.service;

import java.sql.SQLException;

import javax.ws.rs.core.Response;

import com.restEasy.model.User;

public interface UserService {

	public Response addUser(User user);
	
	public Response deleteUser(int id);
	
	public <T>  T getUser(int id) throws SQLException;
	
	public User[] getAllUsers();

}
