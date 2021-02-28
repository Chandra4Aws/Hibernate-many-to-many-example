package com.boraji.tutorial.hibernate.entity;

import java.util.HashSet;
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
@Table(name = "SUPPLIER")
public class Supplier {
    private long id;
    private String sup_name;
    private String sup_type;
    private boolean sup_active;  


    private Set<Address> address;
    
    private Set<SupplierItem> userGroups = new HashSet<SupplierItem>();
 
    public Supplier() {
    }
 
    public Supplier(String sup_name, String sup_type, boolean sup_active) {
        this.sup_active = sup_active;
        this.sup_type = sup_type;
        this.sup_active = sup_active;
    }
     
    public void addGroup(SupplierItem group) {
        this.userGroups.add(group);
    }
 
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "sup_id")
    public long getId() {
        return id;
    }
 

    
    public void setId(long id) {
        this.id = id;
    }
 
   
 
    public String getSup_name() {
		return sup_name;
	}

	public void setSup_name(String sup_name) {
		this.sup_name = sup_name;
	}

	public String getSup_type() {
		return sup_type;
	}

	public void setSup_type(String sup_type) {
		this.sup_type = sup_type;
	}

	public boolean isSup_active() {
		return sup_active;
	}

	public void setSup_active(boolean sup_active) {
		this.sup_active = sup_active;
	}

	@OneToMany(mappedBy = "supplier")
    public Set<SupplierItem> getUserGroups() {
        return userGroups;
    }
 
    public void setUserGroups(Set<SupplierItem> groups) {
        this.userGroups = groups;
    }
     
    public void addUserGroup(SupplierItem userGroup) {
        this.userGroups.add(userGroup);
    }

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="add_sup_id")
	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}  
    
    
}