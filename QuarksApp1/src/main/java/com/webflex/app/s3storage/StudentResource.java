package com.webflex.app.s3storage;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

	@Inject
	StudentRepository repo;
	
	@GET
	public List<Student> getAll(){
		return repo.listAll();
	}
	
	@POST
	public void create(Student student) {
		repo.persist(student);
	}
	

    @GET
    @Path("/{id}")
    public Student getById(@PathParam("id") Long id) {
        return repo.findById(id);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Long id, Student updated) {
        Student s = repo.findById(id);
        s.name = updated.name;
        s.age = updated.age;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        repo.deleteById(id);
    }
	
}
