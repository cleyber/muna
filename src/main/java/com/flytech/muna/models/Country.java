package com.flytech.muna.models;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GenerationType;

import java.io.Serializable;
import com.flytech.muna.models.Region;

@Entity
@Table(name = "COUNTRIES")
public class Country implements Serializable {

   private static final long serialVersionUID = 1L;


}
