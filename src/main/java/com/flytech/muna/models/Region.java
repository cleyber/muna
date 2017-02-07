package com.flytech.muna.models;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

import java.io.Serializable;



import java.io.Serializable;

@Entity
@Table(name = "REGIONS")
public class Region implements Serializable{

   private static final long serialVersionUID = 1L;

   @Id
   @SequenceGenerator(name = "regionSeq", sequenceName = "REGIONS_SEQ", allocationSize = 1, initialValue = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regionSeq")
   @Column(name = "REGION_ID")
   private long id;

   @Column(name = "REGION_NAME")
   private String name;

   public Region(){
   }

   public void setId(long id){
      this.id = id;
   }

   public long getId(){
      return id;
   }

   public void setName(String name){
      this.name = name;
   }

   public String getName(){
      return name;
   }

   @Override
   public String toString(){
      return "Region: [ Id: " + id + ", Name: " + name + " ]";
   }


}
