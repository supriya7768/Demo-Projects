package com.bnt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bnt.entity.Song;
import com.bnt.utils.HibernateUtils;

public class DeleteApp {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionfactory();
    	
    	Session session = sessionFactory.openSession();
    	
    	Song song = session.get(Song.class, 1);
    	
    	session.beginTransaction();
		session.delete(song);
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
		}

}
