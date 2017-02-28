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

import com.flytech.muna.models.Job;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Path("jobs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JobsController {
   EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");

   @POST
   public Response save(Job job){
      try{
         EntityManager entityManager = emFactory.createEntityManager();
         entityManager.getTransaction().begin();
         entityManager.persist(job);
         entityManager.getTransaction().commit();
         entityManager.close();
         return Response.status(Status.CREATED).entity(job).build();
      }catch(Exception ex){// Lo debo capturar con sqlexception
         return Response.serverError().build();
      }

   }

   @GET
   public Response findAll(){
      EntityManager entityManager = emFactory.createEntityManager();
      List<Job> job = entityManager.createQuery("FROM Job").getResultList();
      return Response.ok(job).build();
   }

   @Path("{id}")
   @GET
   public Response find(@PathParam("id") String id){
      EntityManager entityManager = emFactory.createEntityManager();
      Job job = entityManager.find(Job.class, id);
      if(job != null)
         return Response.ok(job).build();
      else
         return Response.status(Status.NOT_FOUND).build();
   }

   @Path("{id}")
   @PUT
   public Response update(@PathParam("id") String id, Job job){
      try {
         EntityManager entityManager = emFactory.createEntityManager();
         entityManager.getTransaction().begin();
         Job findJob = entityManager.find(Job.class, id);
         if(findJob != null){
            findJob.setTitle(job.getTitle());
            findJob.setMinSalary(job.getMinSalary());
            findJob.setMaxSalary(job.getMaxSalary());
            entityManager.merge(findJob);
            entityManager.getTransaction().commit();
            entityManager.close();
            return Response.ok(findJob).build();
         }else{
            entityManager.getTransaction().commit();
            entityManager.close();
            return Response.status(Status.NOT_FOUND).build();
         }
      }catch(Exception ex){
         return Response.serverError().build();
      }
   }

   @Path("{id}")
   @DELETE
   public Response delete(@PathParam("id") String id){
      EntityManager entityManager = emFactory.createEntityManager();
      try{
         entityManager.getTransaction().begin();
         Job job = entityManager.find(Job.class, id);
         if(job != null){
            entityManager.remove(job);
            entityManager.getTransaction().commit();
            entityManager.close();
            return Response.noContent().build();
         }else{
            entityManager.getTransaction().commit();
            entityManager.close();
            return Response.status(Status.NOT_FOUND).build();
         }
      }catch(Exception ex){
         return Response.serverError().build();
      }
   }



}
