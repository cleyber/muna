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
import com.flytech.muna.models.Country;

@Entity
@Table(name = "LOCATIONS")
public class Location implements Serializable{

   private static final long serialVersionUID = 1L;

   @Id
   @SequenceGenerator(name = "locationSeq", sequenceName = "LOCATIONS_SEQ", allocationSize = 1, initialValue = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locationSeq")
   @Column(name = "LOCATION_ID")
   private long id;

   @Column(name = "STREET_ADDRESS")
   private String address;

   @Column(name = "POSTAL_CODE")
   private String codePostal;

   @Column(name = "CITY")
   private String city;

   @Column(name = "STATE_PROVINCE")
   private String province;

   @ManyToOne
   @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
   private Country country;

   public Location(){
   }

   public void setId(long id){
      this.id = id;
   }

   public long getId(){
      return id;
   }

   public void setAddress(String address){
      this.address = address;
   }

   public String getAddress(){
      return address;
   }

   public void setCodePostal(String codePostal){
      this.codePostal = codePostal;
   }

   public String getCodePostal(){
      return codePostal;
   }

   public void setCity(String city){
      this.city = city;
   }

   public String getCity(){
      return city;
   }

   public void setProvince(String province){
      this.province = province;
   }

   public String getProvince(){
      return province;
   }

   public void setCountry(Country country){
      this.country = country;
   }

   public Country getCountry(){
      return country;
   }


}
