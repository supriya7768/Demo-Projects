package com.bnt.annotation2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("beans-annotation2.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CollegeConfig.class);
//        System.out.println("xml file loaded");
        College college = context.getBean("college", College.class);
        System.out.println("the college object created by spring" + college);
        college.test();
        context.close();

    }
}
