package com.boraji.tutorial.hibernate.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	private long id;
    private int car_qty;
    private Double car_amount;
    private String car_source_reference;
    
	 
	 private Set<Items> items;
	 
		@Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    @Column(name = "car_id")
	    public long getId() {
	        return id;
	    }
	 

	    
	    public void setId(long id) {
	        this.id = id;
	    }


	    @OneToMany(mappedBy="cart")
		public Set<Items> getItems() {
			return items;
		}



		public void setItems(Set<Items> items) {
			this.items = items;
		}



		public int getCar_qty() {
			return car_qty;
		}



		public void setCar_qty(int car_qty) {
			this.car_qty = car_qty;
		}



		public Double getCar_amount() {
			return car_amount;
		}



		public void setCar_amount(Double car_amount) {
			this.car_amount = car_amount;
		}



		public String getCar_source_reference() {
			return car_source_reference;
		}



		public void setCar_source_reference(String car_source_reference) {
			this.car_source_reference = car_source_reference;
		}
	    
	    
}
