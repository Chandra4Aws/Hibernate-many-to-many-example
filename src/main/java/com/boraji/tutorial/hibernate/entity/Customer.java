package com.boraji.tutorial.hibernate.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    private long id;
    private String cus_name;
    private String cus_email;
    private String cus_phone;
    private String cus_password;
    private Set<Address> address;
    private Set<Order> orders;
    
    public Customer() {
    }
 
    public Customer(String cus_name, String cus_email, String cus_phone, String cus_password) {
        this.cus_name = cus_name;
        this.cus_email = cus_email;
        this.cus_phone = cus_phone;
    }
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cus_id")
    public long getId() {
        return id;
    }
    
	public void setId(long id) {
		this.id = id;
	}
    
    public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getCus_email() {
		return cus_email;
	}

	public void setCus_email(String cus_email) {
		this.cus_email = cus_email;
	}

	public String getCus_phone() {
		return cus_phone;
	}

	public void setCus_phone(String cus_phone) {
		this.cus_phone = cus_phone;
	}

	public String getCus_password() {
		return cus_password;
	}

	public void setCus_password(String cus_password) {
		this.cus_password = cus_password;
	}

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="add_cus_id")
	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="ord_cus_id")
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}
