package com.bnt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_detail")
public class StudentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "college")
    private String college;

    @Column(name = "no_of_problem_solved")
    private int noOfProblemSolved;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getNoOfProblemSolved() {
        return noOfProblemSolved;
    }

    public void setNoOfProblemSolved(int noOfProblemSolved) {
        this.noOfProblemSolved = noOfProblemSolved;
    }

    public StudentDetail( String college, int noOfProblemSolved) {
        this.college = college;
        this.noOfProblemSolved = noOfProblemSolved;
    }

    @Override
    public String toString() {
        return "StudentDetail [id=" + id + ", college=" + college + ", noOfProblemSolved=" + noOfProblemSolved + "]";
    }
    
}
