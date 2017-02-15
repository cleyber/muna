package com.flytech.muna.models;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

import java.io.Serializable;
import com.flytech.muna.models.Region;

@Entity
@Table(name = "COUNTRIES")
public class Country implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "COUNTRY_ID", length = 2)
   private String id;

   @Column(name = "COUNTRY_NAME")
   private String name;

   @ManyToOne
   @JoinColumn(name = "REGION_ID")
   private Region region;

   public Country(){
   }

   public void setId(String id){
      this.id = id;
   }

   public String getId(){
      return id;
   }

   public void setName(String name){
      this.name = name;
   }

   public String getName(){
      return name;
   }

   public void setRegion(Region region){
      this.region = region;
   }

   public Region getRegion(){
      return region;
   }

   @Override
   public String toString(){
      return "Countries: [Cod: " + id + ", Name: " + name + ", CodRegion: " + region.getId() + "]";
   }

}
