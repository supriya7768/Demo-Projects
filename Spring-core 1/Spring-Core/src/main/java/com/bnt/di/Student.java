package com.bnt.di;

public class Student {

    private int id;
    private String studentName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("Setter method of id activated");
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        System.out.println("Setter method of studentName activated");
        this.studentName = studentName;
    }

    public Student(int id, String studentName) {
        System.out.println("Constructor activated");
        this.id = id;
        this.studentName = studentName;

    }

    public Student(int id){
        System.out.println("Constructor with only id activated");
        this.id = id;
    }

    public Student(){
        System.out.println("Default constructor");
    }

    public void displayStudentInfo(){
        System.out.println("Student name is : " + studentName + " and id is " + id);
    }
}
