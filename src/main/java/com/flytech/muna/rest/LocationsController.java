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

import com.flytech.muna.models.Location;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Path("locations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LocationsController {
   EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");

   @POST
   public Response save(Location location){
      try{
         EntityManager entityManager = emFactory.createEntityManager();
         entityManager.getTransaction().begin();
         entityManager.persist(location);
         entityManager.getTransaction().commit();
         entityManager.close();
         return Response.status(Status.CREATED).entity(location).build();
      }catch(Exception ex){
         return Response.serverError().build();
      }
   }

   @GET
   public Response findAll(){
      try {
         EntityManager entityManager = emFactory.createEntityManager();
         List<Location> locations = entityManager.createQuery("FROM Location").getResultList();
         return Response.ok(locations).build();
      }catch(Exception ex){
         return Response.serverError().build();
      }
   }

   @Path("{id}")
   @GET
   public Response find(@PathParam("id") long id){
      EntityManager entityManager = emFactory.createEntityManager();
      Location location = entityManager.find(Location.class, id);
      if(location != null)
         return Response.ok(location).build();
      else
         return Response.status(Status.NOT_FOUND).build();
   }

   @Path("{id}")
   @PUT
   public Response update(@PathParam("id") long id, Location location){
      try{
         EntityManager entityManager = emFactory.createEntityManager();
         entityManager.getTransaction().begin();
         Location findLocation = entityManager.find(Location.class, id);
         if(findLocation != null){
            findLocation.setAddress(location.getAddress());
            findLocation.setCodePostal(location.getCodePostal());
            findLocation.setCity(location.getCity());
            findLocation.setProvince(location.getProvince());
            findLocation.setCountry(location.getCountry());
            entityManager.merge(findLocation);
            entityManager.getTransaction().commit();
            entityManager.close();
            return Response.ok(findLocation).build();
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
   public Response delete(@PathParam("id") long id){
      EntityManager entityManager = emFactory.createEntityManager();
      Location location = entityManager.find(Location.class, id);
      if(location != null){
         entityManager.getTransaction().begin();
         entityManager.remove(location);
         entityManager.getTransaction().commit();
         return Response.noContent().build();
      }else{
         return Response.status(Status.NOT_FOUND).build();
      }
   }
}
