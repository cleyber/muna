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

import com.flytech.muna.models.Country;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Path("country")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CountriesController {

   @POST
   public Response save(Country country){
      try{
         EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
         EntityManager entityManager = emFactory.createEntityManager();
         entityManager.getTransaction().begin();
         entityManager.persist(country);
         entityManager.getTransaction().commit();
         return Response.status(Status.CREATED).entity(country).build();
      }catch(Exception ex){
         return Response.serverError().build();
      }
   }

   @GET
   public Response findAll(){
      EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
      EntityManager entityManager = emFactory.createEntityManager();
      List<Country> countries = entityManager.createQuery("FROM Country").getResultList();
      return Response.ok(countries).build();
   }

   @Path("{id}")
   @GET
   public Response find(@PathParam("id") String id){
      EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
      EntityManager entityManager = emFactory.createEntityManager();
      Country country = entityManager.find(Country.class, id);
      if(country != null)
         return Response.ok(country).build();
      else
         return Response.status(Status.NOT_FOUND).build();
   }

   @Path("{id}")
   @PUT
   public Response update(@PathParam("id") String id, Country country) {
      EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
      EntityManager entityManager = emFactory.createEntityManager();
      Country findCountry = entityManager.find(Country.class, id);
      if(findCountry != null){
         findCountry.setName(country.getName());
         entityManager.getTransaction().begin();
         entityManager.persist(findCountry);
         entityManager.getTransaction().commit();
         return Response.ok(findCountry).build();
      }else{
         return Response.status(Status.NOT_FOUND).build();
      }
   }

}
