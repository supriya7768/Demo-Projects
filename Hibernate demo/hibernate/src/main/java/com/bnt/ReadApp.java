package com.bnt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bnt.entity.Song;
import com.bnt.utils.HibernateUtils;

public class ReadApp {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionfactory();
    	
    	Session session = sessionFactory.openSession();
		
		Song song = session.get(Song.class, 2);
	  //Song song = session.load(Song.class, 2);      //we can use load also to get
		
		System.out.println(song);
	}

}
