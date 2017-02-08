package com.flytech.muna.rest;

import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import com.flytech.muna.models.Region;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Path("region")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegionsController {

   @POST
   public Response save(Region region){
      EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
      EntityManager entityManager = emFactory.createEntityManager();
      entityManager.getTransaction().begin();
      entityManager.persist(region);
      entityManager.getTransaction().commit();
      return Response.status(Status.CREATED).build();
   }
   @GET
   public Response findAll() {
      EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
      EntityManager entityManager = emFactory.createEntityManager();
      List<Region> regions = entityManager.createQuery("FROM Region").getResultList();
      return Response.ok(regions).build();
   }

   @Path("{id}")
   @GET
   public Response find(@PathParam("id") long id){
      try{
         EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
         EntityManager entityManager = emFactory.createEntityManager();
         if(entityManager.find(Region.class, id) != null){
            Region region = entityManager.find(Region.class, id);
            return Response.ok().entity(region).build();
         }else{
            return Response.status(Status.NOT_FOUND).build();
         }
      }catch(Exception ex){
         return Response.serverError().build();
      }
   }

   @Path("{id}")
   @PUT
   public Response update(@PathParam("id") long id, Region region){
      try{
         EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
         EntityManager entityManager = emFactory.createEntityManager();
         if(entityManager.find(Region.class, id) != null){
            Region findRegion = entityManager.find(Region.class, id);
            entityManager.getTransaction().begin();
            findRegion.setName(region.getName());
            entityManager.persist(findRegion);
            entityManager.getTransaction().commit();
            return Response.ok(findRegion).build();
         }else{
            return Response.status(Status.NOT_FOUND).build();
         }
      }catch(Exception ex){
         return Response.serverError().build();
      }
   }

   @Path("{id}")
   @DELETE
   public Response delete(@PathParam("id") long id){
      try{
         EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
         EntityManager entityManager = emFactory.createEntityManager();
         if(entityManager.find(Region.class, id) != null){
            Region region = entityManager.find(Region.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(region);
            entityManager.getTransaction().commit();
            return Response.noContent().build();
         }else{
            return Response.status(Status.NOT_FOUND).build();
         }
      }catch(Exception ex){
         return Response.serverError().build();
      }
   }

}
