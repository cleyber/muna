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

@Path("employee")
public class EmployeesController {

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
}
