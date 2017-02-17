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
import java.sql.Date;
import java.text.SimpleDateFormat;

@Path("employee")
public class EmployeesController {

   @POST
   public Response save(Employee employee){
      try{
         EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("application");
         EntityManager entityManager = emFactory.createEntityManager();
         entityManager.getTransaction().begin();
         Employee employee2 = new Employee();
         employee.setHireDate(parseDate(employee.getHireDate()));
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

   private Date parseDate(String fecha) {
      try {
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
        java.util.Date date = format.parse(fecha);

        return new Date(date.getTime());
      } catch(Exception e) {
        return null;
      }
    }
}
