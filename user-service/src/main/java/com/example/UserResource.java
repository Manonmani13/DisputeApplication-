package com.example;  	

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.transaction.Transactional;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserRepository repo;

    @GET
    public List<User> getAll() {
        return repo.listAll();
    }

    @POST
    @Transactional
    public void create(User user) {
        repo.persist(user);
    }

    @GET
    @Path("/{id}")
    public User getById(@PathParam("id") Long id) {
        return repo.findById(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void update(@PathParam("id") Long id, User updated) {
        User user = repo.findById(id);
        user.name = updated.name;
        user.age = updated.age;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        repo.deleteById(id);
    }
}
