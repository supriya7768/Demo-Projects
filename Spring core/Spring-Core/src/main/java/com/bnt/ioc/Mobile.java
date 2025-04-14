package com.bnt.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {

    public static void main(String[] args) {

//        Airtel airtel = new Airtel();
//        airtel.calling();
//        airtel.data();
//
//        Vodaphone vodaphone = new Vodaphone();  //we are making changes again and again
//        vodaphone.calling();
//        vodaphone.data();
//
//        Sim sim = new Vodaphone();             //here with sim we can change vodaphone and airtel
//        sim.calling();
//        sim.data();

        //but we dont want to change source code do it in configuration
        //spring create an object and manage the object
        //ioc container will read config file and create object in ioc and store there
        //and this object is beans
        //how will use that object...use getBean("a"); will get a object to use

        ApplicationContext context = new ClassPathXmlApplicationContext("beans-ioc.xml"); //read the config file
        System.out.println("config loaded");
       // Airtel air = (Airtel)context.getBean("airtel");
//        Airtel air = context.getBean("airtel", Airtel.class);
//        air.calling();
//        air.data();

        Sim sim = context.getBean("sim", Sim.class);
        sim.calling();
        sim.data();
    }

}
