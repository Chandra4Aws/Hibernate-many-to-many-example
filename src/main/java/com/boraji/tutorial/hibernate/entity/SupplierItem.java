package com.boraji.tutorial.hibernate.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
@Entity
@Table(name = "SUPPLIER_ITEM")
public class SupplierItem {
    private long id;
    private Supplier supplier;
    private Item item;
     
    // additional fields
    private boolean activated;
    private Date registeredDate;
 
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "supplier_item_id")
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sup_id")  
    public Supplier getSupplier() {
        return supplier;
    }
 
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itm_id")
    public Item getItem() {
        return item;
    }
 
    public void setItem(Item item) {
        this.item = item;
    }
 
    public boolean isActivated() {
        return activated;
    }
 
    public void setActivated(boolean activated) {
        this.activated = activated;
    }
 
    @Column(name = "REGISTERED_DATE")
    @Temporal(TemporalType.DATE)
    public Date getRegisteredDate() {
        return registeredDate;
    }
 
    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
}
