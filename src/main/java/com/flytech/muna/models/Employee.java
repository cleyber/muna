package com.flytech.muna.models;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Date;

import com.fasterxml.jackson.annotation.*;

//Posible solucion a anidaciones en el jackson
// @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
@Table(name = "EMPLOYEES")
public class Employee implements Serializable{

   private static final long serialVersionUID = 1L;

   @Id
   @SequenceGenerator(name = "employeeSeq", sequenceName = "EMPLOYEES_SEQ", allocationSize = 1, initialValue = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSeq")
   @Column(name = "EMPLOYEE_ID")
   private int id;

   @Column(name = "FIRST_NAME")
   private String firstName;

   @Column(name = "LAST_NAME")
   private String lastName;

   @Column(name = "EMAIL")
   private String email;

   @Column(name = "PHONE_NUMBER")
   private String phone;

   @Temporal(TemporalType.DATE)
   @Column(name = "HIRE_DATE")
   private Date hireDate;

   @Column(name = "SALARY")
   private double salary;

   @Column(name = "COMMISSION_PCT", nullable = true)
   private Double commission;


   @ManyToOne(fetch =FetchType.EAGER)
   @JoinColumn(name = "JOB_ID")
   private Job job;

   @ManyToOne(fetch =FetchType.EAGER)
   @JoinColumn(name = "DEPARTMENT_ID")
   private Department department;


   @ManyToOne
   @JoinColumn(name = "MANAGER_ID")
   // @JsonBackReference
   private Employee manager;


   @OneToMany(mappedBy = "manager")
   // @JsonManagedReference
   private List<Employee> employees;

   public Employee(){
   }

   public void setId(int id){
      this.id = id;
   }

   public int getId(){
      return id;
   }

   public void setFirstName(String firstName){
      this.firstName = firstName;
   }

   public String getFirtsName(){
      return firstName;
   }

   public void setLastName(String lastName){
      this.lastName = lastName;
   }

   public String getLastName(){
      return lastName;
   }

   public void setEmail(String email){
      this.email = email;
   }

   public String getEmail(){
      return email;
   }

   public void setPhone(String phone){
      this.phone = phone;
   }

   public String getPhone(){
      return phone;
   }

   public void setHireDate(Date hireDate){
      this.hireDate = hireDate;
   }

   public Date getHireDate(){
      return hireDate;
   }

   public void setSalary(double salary){
      this.salary = salary;
   }

   public double getSalary(){
      return salary;
   }

   public void setCommission(Double commission){
      this.commission = commission;
   }

   public Double getCommission(){
      return commission;
   }

   public void setJob(Job job){
      this.job = job;
   }

   public Job getJob(){
      return job;
   }

   public void setDepartment(Department department){
      this.department = department;
   }

   public Department getDepartment(){
      return department;
   }

   public void setManager(Employee manager){
      this.manager = manager;
   }

   public Employee getManager(){
      return manager;
   }

   // @Override
   // public String toString(){
   //    return "Employee [ Id: " + id + ", First Name: " + firstName +
   //    ", Last Name: " + lastName + ", Email: " + email + ", Phone: " + phone +
   //    ", Job id: " + job + ", Hire Date: " + hireDate + " ]";
   // }

}
