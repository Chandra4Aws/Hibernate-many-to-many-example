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
@Table(name = "orderdetails")
public class OrderDetails {
	private long id;
	private String cart_itm_code;
    private String cart_itm_name;
    private String cart_itm_short_description;
    private String cart_itm_description;
    private Order orders;

    public OrderDetails() {
    	
    }
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ordDet_id")
    public long getId() {
        return id;
    }
 

    
    public void setId(long id) {
        this.id = id;
    }
    

    

	public String getCart_itm_code() {
		return cart_itm_code;
	}



	public void setCart_itm_code(String cart_itm_code) {
		this.cart_itm_code = cart_itm_code;
	}



	public String getCart_itm_name() {
		return cart_itm_name;
	}



	public void setCart_itm_name(String cart_itm_name) {
		this.cart_itm_name = cart_itm_name;
	}



	public String getCart_itm_short_description() {
		return cart_itm_short_description;
	}



	public void setCart_itm_short_description(String cart_itm_short_description) {
		this.cart_itm_short_description = cart_itm_short_description;
	}



	public String getCart_itm_description() {
		return cart_itm_description;
	}



	public void setCart_itm_description(String cart_itm_description) {
		this.cart_itm_description = cart_itm_description;
	}


	
	  @ManyToOne
	  @JoinColumn(name="ord_id") 
	  public Order getOrders() {
		  return orders; 
	  }
	  
	  public void setOrders(Order order) { this.orders = order; }
	 
	
}
