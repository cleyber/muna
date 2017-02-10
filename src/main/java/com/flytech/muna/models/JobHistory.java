package com.flytech.muna.models;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import java.io.Serializable;
import java.time.LocalDate;
import com.flytech.muna.models.Job;
import com.flytech.muna.models.Location;
import com.flytech.muna.models.Employee;

@Entity
@Table(name = "JOB_HISTORY")
public class JobHistory implements Serializable{

   private static final long serialVersionUID = 1L;

   @Column(name = "START_DATE")
   private LocalDate startDate;

   @Column(name = "END_DATE")
   private LocalDate endDate;

   @Id
   private int id;

   @ManyToOne
   @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
   private Employee employee;

   @ManyToOne
   @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID")
   private Job job;

   @ManyToOne
   @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
   private Department department;

   public JobHistory(){
   }

   public void setStartDate(LocalDate startDate){
      this.startDate = startDate;
   }

   public LocalDate getStartDate(){
      return startDate;
   }

   public void setEndDate(LocalDate endDate){
      this.endDate = endDate;
   }

   public LocalDate getEndDate(){
      return endDate;
   }

   public void setEmployee(Employee employee){
      this.employee = employee;
   }

   public Employee getEmployee(){
      return employee;
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
