package com.flytech.muna.models;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;

import java.io.Serializable;
import com.flytech.muna.models.Location;
import com.flytech.muna.models.Employee;

@Entity
@Table(name = "DEPARTMENTS")
public class Department implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @SequenceGenerator(name = "departmentSeq", sequenceName = "DEPARTMENTS_SEQ", allocationSize = 1, initialValue = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departmentSeq")
   @Column(name = "DEPARTMENT_ID")
   private long id;

   @Column(name = "DEPARTMENT_NAME")
   private String name;

   @ManyToOne
   @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
   private Location location;

   public Department(){
   }

}
