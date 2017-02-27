package com.flytech.muna.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import com.flytech.muna.models.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.text.SimpleDateFormat;


@Path("employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeesController {

   @POST
   public Response save(Employee employee){
      try{
         EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
         EntityManager entityManager = emFactory.createEntityManager();
         entityManager.getTransaction().begin();
         entityManager.persist(employee);
         entityManager.getTransaction().commit();
         return Response.status(Status.CREATED).entity(employee).build();
      }catch(Exception ex){
         return Response.ok(ex.getMessage()).build();
      }

   }

   @GET
   public Response findAll(){
      try{
         EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
         EntityManager entityManager = emFactory.createEntityManager();
         List<Employee> employees = entityManager.createQuery("FROM Employee").getResultList();
         return Response.ok(employees).build();
      }catch(Exception ex){
         return Response.ok(ex.getMessage()).build();
      }

   }

   @Path("{id}")
   @GET
   public Response find(@PathParam("id") int id){
      EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
      EntityManager entityManager = emFactory.createEntityManager();
      Employee employee = entityManager.find(Employee.class, id);
      if(employee != null)
         return Response.ok(employee).build();
      else
         return Response.status(Status.NOT_FOUND).build();
   }

}
