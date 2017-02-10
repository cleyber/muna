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
import javax.persistence.JoinColumn;

import java.io.Serializable;
import java.time.LocalDate;
import com.flytech.muna.models.Job;

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
   private String lastaName;

   @Column(name = "EMAIL")
   private String email;

   @Column(name = "PHONE_NUMBER")
   private String phone;

   @Column(name = "HIRE_DATE")
   private LocalDate hireDate;

   @Column(name = "SALARY")
   private double salary;

   @Column(name = "COMMISSION_PCT")
   private Double commission;

   @ManyToOne(optional = false)
   @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID")
   private Job job;

   @ManyToOne(optional = false)
   @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
   private Department department;

   @ManyToOne(optional = false)
   @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
   private Employee manager;

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

   public void setLastName(String lastaName){
      this.lastaName = lastaName;
   }

   public String getLastName(){
      return lastaName;
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

   public void setHireDate(LocalDate hireDate){
      this.hireDate = hireDate;
   }

   public LocalDate getHireDate(){
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


}
