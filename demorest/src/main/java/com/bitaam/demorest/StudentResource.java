package com.bitaam.demorest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
public class StudentResource {
	
	StudentRepository repo = new StudentRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudent() {
		
		
		return repo.getStudents();
	}
	
	@GET
	@Path("student/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam("id") String id) {
		return repo.getStudent(id);
	}
	
//	@PUT
//	@Path("studentu")
//	public String updateStudentName(String id,String name) {
//		
//		repo.updateStudent(name,id);
//		
//		return name;
//	}
	
	@DELETE
	@Path("student/{id}")
	public String deleteStudent(@PathParam("id") String id) {
		
		return repo.updateStudent(id);
	}
	
	@POST
	@Path("student")
	public Student createStudent(Student s) {
		
		repo.createStudent(s);
		return s;
	}

}
