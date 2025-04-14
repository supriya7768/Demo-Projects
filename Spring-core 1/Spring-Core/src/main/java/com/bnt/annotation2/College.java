package com.bnt.annotation2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("college")                       //default bean id will be class name
//@Component("collegeBean")                   //create object of that particular class and store in IOC----do work of <bean id = "collegeBean" class = "com.bnt.annotation2.College"></bean>
@Component
public class College {

//    @Value("RCPIT")
    @Value("${college.name}")
      private String collegeName;

    @Autowired
    private Principal principal;

    @Autowired
    @Qualifier("scienceTeacher")
    private Teacher teacher;

//    @Autowired
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//
//    @Autowired
//    public College(Principal principal) {
//        this.principal = principal;
//    }

    public void test(){
        System.out.println("Testing method");
        principal.principalInfo();
        teacher.teach();
        System.out.println("My college name is " + collegeName);
    }

}
