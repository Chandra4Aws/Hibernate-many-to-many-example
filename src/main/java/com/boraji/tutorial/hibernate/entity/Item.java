package com.boraji.tutorial.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "ITEM")
public class Item {
    private long id;
    private String itm_code;
    private String itm_name;
    private String itm_short_description;
    private String itm_description;
    private Double itm_commission_percentage;
    private String itm_unit_type;
    private String itm_image_path;
 
    private Set<SupplierItem> userGroups = new HashSet<SupplierItem>();
     
    public Item() {
    }
 
    public Item(String name) {
        this.itm_name = name;
    }
         
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "itm_id")
    public long getId() {
        return id;
    }
 

	private Category category;
    
    public void setId(long id) {
        this.id = id;
    }
 
 
    public String getItm_code() {
		return itm_code;
	}

	public void setItm_code(String itm_code) {
		this.itm_code = itm_code;
	}

	public String getItm_name() {
		return itm_name;
	}

	public void setItm_name(String itm_name) {
		this.itm_name = itm_name;
	}

	public String getItm_short_description() {
		return itm_short_description;
	}

	public void setItm_short_description(String itm_short_description) {
		this.itm_short_description = itm_short_description;
	}

	public String getItm_description() {
		return itm_description;
	}

	public void setItm_description(String itm_description) {
		this.itm_description = itm_description;
	}

	public Double getItm_commission_percentage() {
		return itm_commission_percentage;
	}

	public void setItm_commission_percentage(Double itm_commission_percentage) {
		this.itm_commission_percentage = itm_commission_percentage;
	}

	public String getItm_unit_type() {
		return itm_unit_type;
	}

	public void setItm_unit_type(String itm_unit_type) {
		this.itm_unit_type = itm_unit_type;
	}

	public String getItm_image_path() {
		return itm_image_path;
	}

	public void setItm_image_path(String itm_image_path) {
		this.itm_image_path = itm_image_path;
	}

	@OneToMany(mappedBy = "item")
    public Set<SupplierItem> getUserGroups() {
        return userGroups;
    }
 
    public void setUserGroups(Set<SupplierItem> groups) {
        this.userGroups = groups;
    }
     
    public void addUserGroup(SupplierItem userGroup) {
        this.userGroups.add(userGroup);
    }
    
    @ManyToOne
	@JoinColumn(name="itm_cat_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
 
}