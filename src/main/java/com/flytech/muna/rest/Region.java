package com.flytech.muna.rest;

import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
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
public class Region {

   @GET
   public Response findAll() {
      EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
      EntityManager entityManager = emFactory.createEntityManager();
      entityManager.getTransaction().begin();
      List<Region> regions = (List<Region>) entityManager.createQuery("FROM Region").getResultList();
      entityManager.getTransaction().commit();
      return Response.ok(regions).build();
   }

}
