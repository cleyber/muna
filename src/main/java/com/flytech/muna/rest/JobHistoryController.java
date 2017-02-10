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

import com.flytech.muna.models.JobHistory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Path("history")
public class JobHistoryController {
   
   @GET
   public Response findAll(){
      try{
         EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
         EntityManager entityManager = emFactory.createEntityManager();
         List<JobHistory> histories = entityManager.createQuery("FROM JobHistory").getResultList();
         return Response.ok(histories).build();
      }catch(Exception ex){
         return Response.ok(ex.getMessage()).build();
      }

   }
}
