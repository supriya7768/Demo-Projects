package com.bnt;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bnt.entity.Library;
import com.bnt.entity.Student;
import com.bnt.entity.StudentDetail;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .addAnnotatedClass(StudentDetail.class)
                                        .buildSessionFactory();

        try (
        Session session = sessionFactory.getCurrentSession()){
            
        Student student = new Student("Supriya", "Mahajan", "mahajansupriya@gmail.com");
        StudentDetail studentDetail = new StudentDetail( "RCPIT", 10);

        student.setStudentDetail(studentDetail);
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();

        sessionFactory.close();

        } catch (Exception e) {
           e.printStackTrace();
        }

        try (Session session = sessionFactory.getCurrentSession()){

            Library lib1 = new Library("Data structure");
            Library lib2 = new Library("DBMS");
            ArrayList<Library> list = new ArrayList<>();
            list.add(lib1);
            list.add(lib2);

            Student s1 = new Student();
            s1.setFirstName("Supriya");
            s1.setBooksIssued(list);

            session.beginTransaction();
            session.persist(s1);
            session.getTransaction().commit();
            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}