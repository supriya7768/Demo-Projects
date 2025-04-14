package com.bnt.bean_life_cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        StudentDAO dao = new StudentDAO();
//        dao.selectAllRows();
//        dao.deleteStudentRecord(1);

        ApplicationContext context = new ClassPathXmlApplicationContext("beans-lifecycle.xml");
        StudentDAO studentDAO = context.getBean("studentDAO", StudentDAO.class);
        studentDAO.selectAllRows();
        ((ClassPathXmlApplicationContext)context).close();     //when we call close method it will invoke predestroy

        //In WEBAPP we dont create and destroy the container object. this will do automatically.
        //This is standlone application

        // ((ClassPathXmlApplicationContext) context).registerShutdownHook();
        // this is same as close(). but it will execute once the main thread ends.So once your code
        // gets executed , it will be called and close your container. So it wont give exception
        // irrespective of the line no we are calling
    }
}
