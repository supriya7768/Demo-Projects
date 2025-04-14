package com.bnt.loosecoupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans-loosecoupling.xml");
        System.out.println("xml file loaded");
        Student student = context.getBean("stu", Student.class);
        student.cheating();

    }
}
