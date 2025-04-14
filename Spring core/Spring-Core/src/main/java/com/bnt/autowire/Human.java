package com.bnt.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Human {

    private Heart heart;

    //@Autowired      //autowire by constructor
    public Human(Heart heart) {
        this.heart = heart;
    }

    public Human(){

    }

    @Autowired       //autowire byType if it fails then go for byName
    @Qualifier("heartObjectValue")
    public void setHeart(Heart heart) {
        this.heart = heart;
    }

    public void startPumping(){
        if(heart!=null){
        heart.pump();
            System.out.println("name of animal is : " + heart.getNameOfAnimal() + " no of heart present is : "+ heart.getNoOfHeart());
        }
        else System.out.println("You are dead");
    }
}
