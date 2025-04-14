package com.bnt.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam {

    public static void main(String[] args) {

//        Student student = new Student();
        //student.studentName = "Supriya";     //it is private
//        student.setStudentName("Supriya");   //if we use setter method
//        student.displayStudentInfo();

//        Student st = new Student(1, "Supriya");
//        st.displayStudentInfo();                 //if we use constructor

        ApplicationContext context = new ClassPathXmlApplicationContext("beans-di.xml");
        
       Student sup = context.getBean("supriya", Student.class);
       sup.displayStudentInfo();
//
//        Student vij = context.getBean("vijaya", Student.class);
//        vij.displayStudentInfo();

        Student jay = context.getBean("jayesh", Student.class);
        jay.displayStudentInfo();

        // Student gan = context.getBean("ganesh", Student.class);
        // gan.displayStudentInfo();

        

    }
}
