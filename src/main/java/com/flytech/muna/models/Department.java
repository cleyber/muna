package com.flytech.muna.models;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import java.io.Serializable;
import com.flytech.muna.models.Location;
import com.flytech.muna.models.Employee;
import java.util.List;

@Entity
@Table(name = "DEPARTMENTS")
public class Department implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @SequenceGenerator(name = "departmentSeq", sequenceName = "DEPARTMENTS_SEQ", allocationSize = 1, initialValue = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departmentSeq")
   @Column(name = "DEPARTMENT_ID")
   private int id;

   @Column(name = "DEPARTMENT_NAME")
   private String name;

   @ManyToOne
   @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
   private Location location;

   @ManyToOne
   @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
   private List<Employee> manager;

   public Department(){
   }

   public void setId(int id){
      this.id = id;
   }

   public int getId(){
      return id;
   }

   public void setName(String name){
      this.name = name;
   }

   public String name(){
      return name;
   }

   public void setLocation(Location location){
      this.location = location;
   }

   public Location getLocation(){
      return location;
   }

   public void setManager(List<Employee> manager){
      this.manager = manager;
   }

   public List<Employee> getManager(){
      return manager;
   }

}
