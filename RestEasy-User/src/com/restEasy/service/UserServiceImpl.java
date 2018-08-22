package com.restEasy.service;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.restEasy.model.GenericResponse;
import com.restEasy.model.User;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserServiceImpl implements UserService {

	
	private static Map<Integer,User> users = new HashMap<Integer,User>();
	
	@Override
	@POST
    @Path("/add")
	public Response addUser(User user) {
		GenericResponse response = new GenericResponse();
		
		if(users.get(user.getId()) != null){
			response.setStatus(false);
			response.setMessage("User Already Exists");
			response.setErrorCode("EC-01");
			return Response.status(422).entity(response).build();
		}
		users.put(user.getId(), user);
		response.setStatus(true);
		response.setMessage("User created successfully");
		return Response.ok(response).build();
	}

	@Override
	@DELETE
    @Path("/{id}/delete")
	public Response deleteUser(@PathParam("id") int id) {
		GenericResponse response = new GenericResponse();
		if(users.get(id) == null){
			response.setStatus(false);
			response.setMessage("User Doesn't Exists");
			response.setErrorCode("EC-02");
			return Response.status(404).entity(response).build();
		}
		users.remove(id);
		response.setStatus(true);
		response.setMessage("User deleted successfully");
		return Response.ok(response).build();
	}

	@Override
	@GET
	@Path("/{id}/get")
	public <T> T getUser(@PathParam("id") int id) throws SQLException{
		GenericResponse response = new GenericResponse();
		
		if(users.get(id) == null){
			response.setErrorCode("EC-05");
			response.setMessage("User Not Existed");
			response.setStatus(false);
			return (T) response;
		}
		
		return (T) users.get(id);
	}
	
	@GET
	@Path("/{id}/getDummy")
	public User getDummyUser(@PathParam("id") int id) {
		User user = new User();
		user.setFirstName("sun");;
		user.setLastName("kumar");;
		user.setId(12);;
		return user;
	}

	@Override
	@GET
	@Path("/getAll")
	public User[] getAllUsers() {
		Set<Integer> ids = users.keySet();
		User[] user = new User[ids.size()];
		int i=0;
		for(Integer id : ids){
			user[i] = users.get(id);
			i++;
		}
		return user;
	}

}
