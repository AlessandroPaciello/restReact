package com.example.restreact.api;


import com.example.restreact.bean.User;
import com.example.restreact.connection.SQLConnection;
import com.example.restreact.crud.SQLCrud;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class restUsers {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        List<User> users = SQLCrud.getAllUsers(SQLConnection.getMySQLConnection());
        return users;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") int id) {
        User user = SQLCrud.getUser(SQLConnection.getMySQLConnection(), id);
        return user;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User addUser(User user) {

        System.out.println(user.getFirstName() + " " + user.getLastName());
        SQLCrud.addUser(SQLConnection.getMySQLConnection(), user);
        return user;
    }
}
