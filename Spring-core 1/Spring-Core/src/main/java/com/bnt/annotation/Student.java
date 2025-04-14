package com.bnt.annotation;

import org.springframework.beans.factory.annotation.Value;

public class Student {

//    @Value("${student.name}")      //if i use value here above field than we do not require set methods
    private String name;
    private String intrestedCourse;
    private String hobby;

//    @Value("Supriya")
    @Value("${student.name}")
    public void setName(String name) {
        this.name = name;
    }

    @Value("Java")
    public void setIntrestedCourse(String intrestedCourse) {
        this.intrestedCourse = intrestedCourse;
    }

    @Value("Music")
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void displayStudentInfo(){
        System.out.println("Student name : "+ name);
        System.out.println("Intrested course : " + intrestedCourse);
        System.out.println("Hobby : "+ hobby);
    }
}
