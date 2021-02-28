package com.boraji.tutorial.hibernate.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "orders")
public class Order {

	private long id;
    private int ord_qty;
    private Double ord_amount;
    private java.util.Date ord_date;
    private java.util.Date ord_delivery_date;
    //private int ord_status_id;
    //private int ord_payment_id;
    //private int ord_add_id;
    private String ord_comments;
    
   
    private Customer customer;
    
    public Order() {
    	
    }
    
    //private Set<Address> address;
    
	 private Set<OrderDetails> orderDetails;
	 
		@Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    @Column(name = "ord_id")
	    public long getId() {
	        return id;
	    }
	 

	    
	    public void setId(long id) {
	        this.id = id;
	    }


	    @OneToMany(mappedBy="orders", cascade = CascadeType.ALL)
		public Set<OrderDetails> getOrderDetails() {
			return orderDetails;
		} 



		public void setOrderDetails(Set<OrderDetails> items) {
			this.orderDetails = items;
		}


		@ManyToOne
		@JoinColumn(name="ord_cus_id")
		public Customer getCustomer() {
			return customer;
		}



		public void setCustomer(Customer customer) {
			this.customer = customer;
		}



		public int getOrd_qty() {
			return ord_qty;
		}



		public void setOrd_qty(int ord_qty) {
			this.ord_qty = ord_qty;
		}



		public Double getOrd_amount() {
			return ord_amount;
		}



		public void setOrd_amount(Double ord_amount) {
			this.ord_amount = ord_amount;
		}



		public java.util.Date getOrd_date() {
			return ord_date;
		}



		public void setOrd_date(java.util.Date ord_date) {
			this.ord_date = ord_date;
		}



		public java.util.Date getOrd_delivery_date() {
			return ord_delivery_date;
		}



		public void setOrd_delivery_date(java.util.Date ord_delivery_date) {
			this.ord_delivery_date = ord_delivery_date;
		}


		public String getOrd_comments() {
			return ord_comments;
		}



		public void setOrd_comments(String ord_comments) {
			this.ord_comments = ord_comments;
		}



	    
}
