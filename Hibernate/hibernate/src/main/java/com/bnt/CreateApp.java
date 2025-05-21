package com.bnt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bnt.entity.Song;
import com.bnt.utils.HibernateUtils;

public class CreateApp 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = HibernateUtils.getSessionfactory();
    	
    	Session session = sessionFactory.openSession();    //creating a connection to database
        
    	Song song1 = new Song();
    	song1.setId(3);
    	song1.setSongName("Kal ho na ho");
    	song1.setSinger("Sonu Nigam");
    	
    	session.beginTransaction();
    	
    	session.save(song1);
    	
    	session.getTransaction().commit();
    	System.out.println("song saved");
    	
    	session.close();
    }
    
    
    //session.save(obj) helps pushing the object to the db
    //database generates a primary key and assigns it to the record to be pushed.
    //Once the record has been inserted, @GeneratedValue (Strategy = Identity) helps mapping the assigned PK from db to the java object.
    //FYI: @GeneratedValue (Strategy = Identity) doesnt generate the PK, its only helps mappping the PK from db to java object after the save() called.


}
