package com.flytech.muna.models;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "EMPLOYEES")
public class Employee implements Serializable{

   private static final long serialVersionUID = 1L;
}
