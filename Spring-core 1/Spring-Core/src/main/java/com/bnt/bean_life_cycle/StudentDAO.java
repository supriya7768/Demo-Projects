package com.bnt.bean_life_cycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import java.sql.*;

public class StudentDAO {

    private String driver;
    private String url;
    private String userName;
    private String password;

    Connection con;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @PostConstruct              //once StudentDAO object is create spring call it by yourself dont wait for me. It is a init method. We dont call init method. we can create any name for it
    public void init() throws ClassNotFoundException, SQLException {
        System.out.println("Creating connection for test");
        createStudentDBConnection();
    }

    public void createStudentDBConnection() throws ClassNotFoundException, SQLException {

        //load driver
        Class.forName(driver);

        //get a connection
       con = DriverManager.getConnection(url, userName, password);
    }

    public void selectAllRows() throws ClassNotFoundException, SQLException {
//        //load driver
//        Class.forName(driver);
//
//        //get a connection
//        Connection con = DriverManager.getConnection(url, userName, password);

//        createStudentDBConnection();

        //execute query
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM testtable");

        while (rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String mobile = rs.getString(3);

            System.out.println(id + "" + name + "" + mobile);
        }
//        con.close();

    }

    public void deleteStudentRecord(int id) throws ClassNotFoundException, SQLException {
//        //load driver
//        Class.forName(driver);
//
//        //get a connection
//        Connection con = DriverManager.getConnection(url, userName, password);

        //execute query
        Statement stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM testtable WHERE id =" + id);
        System.out.println("Record deleted with id " + id);

//        con.close();
    }

    @PreDestroy                  //clean up job. before spring remove studentDAO it will call destroy method
    public void closeConnection() throws SQLException {
        System.out.println("Inside destroy method");
        con.close();
    }

    //In WEBAPP we dont create and destroy the container object. this will do automatically.

}
