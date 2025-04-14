package com.bnt.annotation2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary                                        //math will be primary at autowire but not science
public class MathTeacher implements Teacher{

    @Override
    public void teach() {
        System.out.println("Hi I am your Math Teacher");
    }
}
