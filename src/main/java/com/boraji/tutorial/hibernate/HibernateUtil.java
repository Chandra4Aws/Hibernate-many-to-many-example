package com.boraji.tutorial.hibernate;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
   private static StandardServiceRegistry registry;

   private static SessionFactory buildSessionFactory() {
       try {
           // Create the SessionFactory from hibernate.cfg.xml
           return new Configuration().configure(new File("C:\\Users\\gchandramouli\\Downloads\\hibernate-many-to-many-example\\hibernate-many-to-many-example\\hibernate.cfg.xml")).buildSessionFactory();
 
       }
       catch (Throwable ex) {
           // Make sure you log the exception, as it might be swallowed
           System.err.println("Initial SessionFactory creation failed." + ex);
           throw new ExceptionInInitializerError(ex);
       }
   }

   public static SessionFactory getSessionFactory() {
       return buildSessionFactory();
   }

   
   public static void shutdown() {
      if (registry != null) {
         StandardServiceRegistryBuilder.destroy(registry);
      }
   }
}
