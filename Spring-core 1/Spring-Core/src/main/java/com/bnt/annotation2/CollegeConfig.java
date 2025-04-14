package com.bnt.annotation2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration                                                      //making the class configure
@ComponentScan(basePackages = "com.bnt.annotation2")              //does work of <context:component-scan base-package="com.bnt.annotation2" />
@PropertySource("classpath:student-info.properties")
public class CollegeConfig {

//    @Bean
////    @Bean(name = {"collegeBean", "colBean"})
//    public College collegeBean(){                                  //collegeBean = id
//        College college = new College();
//        return college;
//    }

//    @Bean
//    public Principal principalBean(){
//        return new Principal();
//    }
//
//    @Bean
//    public College collegeBean(){
//        College college = new College(principalBean());
//        college.setTeacher(mathTeacherBean());
//        return college;
//    }
//
//    @Bean
//    public Teacher mathTeacherBean(){
//        return new MathTeacher();
//    }
}
