package com.bnt.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bnt.entity.Song;

public class HibernateUtils {
	
	
	//we are using singleton design pattern so that only one session factory will be created
	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionfactory() {
		
		if(sessionFactory == null) {
		
		Configuration configuration = new Configuration();   //bootstraping hibernate with this   //singleton class
    	configuration.configure("hibernate.cfg.xml");        //if you have file name hibernate.cfg.xml then we can write configure() directly
    	configuration.addAnnotatedClass(Song.class);
    	
    	//SessionFactory sessionFactory = configuration.buildSessionFactory(); //to create datasource we have use session factory it is very heavy. We create only one if have more database then we can create couple of sessionfactory
    	sessionFactory = configuration.buildSessionFactory();
		}
		
    	return sessionFactory;                                               //session factory is immuatble
	}
}
