package com.flytech.muna.models;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;

import java.io.Serializable;

@Entity
@Table(name = "JOBS")
public class Job implements Serializable{

   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "JOB_ID")
   private String id;

   @Column(name = "JOB_TITLE")
   private String title;

   @Column(name = "MIN_SALARY")
   private int minSalary;

   @Column(name = "MAX_SALARY")
   private int maxSalary;

   public Job(){      
   }

   public void setId(String id){
      this.id = id;
   }

   public String getId(){
      return id;
   }

   public void setTitle(String title){
      this.title = title;
   }

   public String getTitle(){
      return title;
   }

   public void setMinSalary(int minSalary){
      this.minSalary = minSalary;
   }

   public int getMinSalary(){
      return minSalary;
   }

   public void setMaxSalary(int maxSalary){
      this.maxSalary = maxSalary;
   }

   public int getMaxSalary(){
      return maxSalary;
   }

}
