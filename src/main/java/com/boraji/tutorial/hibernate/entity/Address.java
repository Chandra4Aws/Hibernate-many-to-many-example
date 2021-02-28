package com.boraji.tutorial.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "address")
public class Address {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "add_id")
   private long id;

   private String add_address1;
   private String add_address2;
   private String add_address3;
   private String add_city;
   private String add_state;
   private String add_country;
   private String add_postacode;
   private String add_type;

   @ManyToOne
   @JoinColumn(name="add_sup_id")
   private Supplier supplier;
   
   public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getAdd_address1() {
	return add_address1;
}

public void setAdd_address1(String add_address1) {
	this.add_address1 = add_address1;
}

public String getAdd_address2() {
	return add_address2;
}

public void setAdd_address2(String add_address2) {
	this.add_address2 = add_address2;
}

public String getAdd_address3() {
	return add_address3;
}

public void setAdd_address3(String add_address3) {
	this.add_address3 = add_address3;
}

public String getAdd_city() {
	return add_city;
}

public void setAdd_city(String add_city) {
	this.add_city = add_city;
}

public String getAdd_state() {
	return add_state;
}

public void setAdd_state(String add_state) {
	this.add_state = add_state;
}

public String getAdd_country() {
	return add_country;
}

public void setAdd_country(String add_country) {
	this.add_country = add_country;
}

public String getAdd_postacode() {
	return add_postacode;
}

public void setAdd_postacode(String add_postacode) {
	this.add_postacode = add_postacode;
}

public String getAdd_type() {
	return add_type;
}

public void setAdd_type(String add_type) {
	this.add_type = add_type;
}

public Supplier getSupplier() {
	return supplier;
}

public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}


 
}
