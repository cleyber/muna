package com.flytech.muna.models;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;

import java.io.Serializable;

@Entity
@Table(name = "LOCATIONS")
public class Location implements Serializable{

   private static final long serialVersionUID = 1L;
}
