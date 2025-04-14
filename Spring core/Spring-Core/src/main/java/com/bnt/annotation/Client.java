package com.bnt.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans-annotation.xml");
        System.out.println("xml file loaded");
        Student student = context.getBean("student", Student.class);
        student.displayStudentInfo();
    }
}
