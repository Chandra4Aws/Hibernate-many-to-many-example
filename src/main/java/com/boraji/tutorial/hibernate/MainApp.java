package com.boraji.tutorial.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.boraji.tutorial.hibernate.entity.Address;
import com.boraji.tutorial.hibernate.entity.Cart;
import com.boraji.tutorial.hibernate.entity.Category;
import com.boraji.tutorial.hibernate.entity.Customer;
import com.boraji.tutorial.hibernate.entity.Item;
import com.boraji.tutorial.hibernate.entity.Items;
import com.boraji.tutorial.hibernate.entity.Order;
import com.boraji.tutorial.hibernate.entity.OrderDetails;
import com.boraji.tutorial.hibernate.entity.Supplier;
import com.boraji.tutorial.hibernate.entity.SupplierItem;

/**
 * @author imssbora
 */
public class MainApp {
	public static void test() {
		
		
		
	}
   public static void main(String[] args) {
      Session session = null;
      Transaction transaction = null;
      try {
         session = HibernateUtil.getSessionFactory().openSession();
         transaction = session.getTransaction();
         transaction.begin();

         // create category
 		Category cat = new Category();
 		cat.setName("Atta & Flour");
 		cat.setActive(true);
 		cat.setId(1);
 		// create item
		
		  Item it = new Item(); //it.setId(1); 
		  it.setCategory(cat); 
		  it.setItm_code("AT02");
		  it.setItm_description("Aashirvaad whole wheat atta is made of zero per cent maida and 100% atta."
		  ); it.setItm_short_description("Aashirvaad Atta - Whole Wheat, 10 kg Pouch");
		  it.setItm_name("Aashirvaad whole wheat atta"); 
		  it.setItm_unit_type("KG");
		  it.setItm_commission_percentage(new Double(10));
		  
			
			  // create supplier 
		  Supplier sup =new Supplier(); //sup.setId(1);
		  sup.setSup_name("Amrutha Store2"); 
		  sup.setSup_type("Retail"); 
		  sup.setSup_active(true);
		  Set<Address> addSet = new HashSet<Address>();
		  
		  Address add = new Address();
		  add.setAdd_address1("add 1");
		  add.setAdd_address2("add 1");
		  add.setAdd_address3("add 1");
		  add.setAdd_city("add 1");
		  add.setAdd_state("add 1");
		  add.setAdd_country("add 1");
		  add.setAdd_postacode("add 1");
		  add.setAdd_type("Shop");
		  addSet.add(add);
		  sup.setAddress(addSet);
			  // map item and supplier // create user //
			  
			 
		 
 		//Supplier supplier = new Supplier("tommy", "ymmot", true);
 		//Item group = new Item("Coders");
 		 
 		SupplierItem supplierItem = new SupplierItem();
 		supplierItem.setItem(it);
 		supplierItem.setSupplier(sup);
 		supplierItem.setActivated(true);
 		supplierItem.setRegisteredDate(new Date());
 		
 		Customer cus = new Customer();
 		cus.setId(1);
 		cus.setAddress(addSet);
 		cus.setCus_name("chandramouli");
 		cus.setCus_email("a@abc.com");
 		cus.setCus_password("AAAA");
 		cus.setCus_phone("123456789");
 		
 		
 		Cart cart = new Cart();
 		cart.setCar_amount(2453.00);
 		cart.setCar_qty(10);
 		cart.setCar_source_reference("abc");
 		
 		Set<Items> cartItems = new HashSet<Items>();
 		Items cartItem = new Items();
 		cartItem.setCart_itm_code("dddd");
 		cartItem.setCart_itm_description("Description");
 		cartItem.setCart_itm_name("Boost");
 		cartItem.setCart_itm_short_description("Short desc");
 		cart.setItems(cartItems);
 		
 		Order ord = new Order();
 		ord.setCustomer(cus);
 		ord.setOrd_amount(4567.00);
 		ord.setOrd_date(new java.util.Date());
 		ord.setOrd_qty(10);
 		
 		
 		Set<OrderDetails> orderDetails = new HashSet<OrderDetails>();
 		OrderDetails orderItem = new OrderDetails();
 		orderItem.setCart_itm_code("dddd");
 		orderItem.setCart_itm_description("Description");
 		orderItem.setCart_itm_name("Boost");
 		orderItem.setCart_itm_short_description("Short desc");
 		orderItem.setOrders(ord);
 		orderDetails.add(orderItem);
 		
 		OrderDetails orderItem2 = new OrderDetails();
 		orderItem2.setCart_itm_code("dddd");
 		orderItem2.setCart_itm_description("Description");
 		orderItem2.setCart_itm_name("Boost");
 		orderItem2.setCart_itm_short_description("Short desc");
 		orderItem2.setOrders(ord);
 		orderDetails.add(orderItem2);
 		
 		
 		ord.setOrderDetails(orderDetails);
 		
 		session.save(ord);
        
        
		/*
		 * SupplierItem sitem = (SupplierItem) session.get(SupplierItem.class, new
		 * Long(1)); System.out.println(sitem.getItem().getItm_code());
		 * System.out.println(sitem.getSupplier().getSup_name());
		 */
         
        transaction.commit();

         System.out.println("Records saved successfully");

      } catch (Exception e) {
         if (transaction != null) {
            System.out.println("Transaction is being rolled back.");
            transaction.rollback();
         }
         e.printStackTrace();
      } finally {
         if (session != null) {
            session.close();
         }
      }
      HibernateUtil.shutdown();
   }
   
  
}
