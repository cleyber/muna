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

import com.flytech.muna.models.Department;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Path("department")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentsController {

   @POST
   public Response save(Department department){
      try{
         EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
         EntityManager entityManager = emFactory.createEntityManager();
         entityManager.getTransaction().begin();
         entityManager.persist(department);
         entityManager.getTransaction().commit();
         return Response.status(Status.CREATED).entity(department).build();
      }catch(Exception ex){
         return Response.ok(ex.getMessage()).build();
      }
   }

   @GET
   public Response findAll(){
      try{
         EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
         EntityManager entityManager = emFactory.createEntityManager();
         List<Department> departments = entityManager.createQuery("FROM Department").getResultList();
         return Response.ok(departments).build();
      }catch(Exception ex){
         return Response.ok(ex.getMessage()).build();
      }

   }


}
