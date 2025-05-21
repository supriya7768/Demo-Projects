package com.bnt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bnt.entity.Song;
import com.bnt.utils.HibernateUtils;

public class UpdateApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionfactory(); 
    	
    	Session session = sessionFactory.openSession();
		
//		Song song = new Song();
//		song.setId(1);
//		song.setSongName("TUM HO");                   //here singer will be null
    	
    	Song song = session.get(Song.class, 3);
    	song.setSongName("KALHO NA HO");
		
		session.beginTransaction();
		session.update(song);
		session.getTransaction().commit();
	}


}
