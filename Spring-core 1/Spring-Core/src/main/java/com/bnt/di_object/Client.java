package com.bnt.di_object;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {

//        Student student = new Student();
//        MathCheat cheat = new MathCheat();
//        student.setMathCheat(cheat);
//        student.cheating();

        ApplicationContext context = new ClassPathXmlApplicationContext("beans-di_object.xml");
        System.out.println("xml file loaded");
        Student student = context.getBean("stu", Student.class);
        student.cheating();

       AnotherStudent anotherStudent = context.getBean("anotherStudent", AnotherStudent.class);
       anotherStudent.startCheating();
    }
}
