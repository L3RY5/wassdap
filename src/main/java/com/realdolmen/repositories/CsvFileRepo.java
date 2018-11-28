/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.repositories;
import com.realdolmen.domain.CsvFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.realdolmen.domain.CsvFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author YLOBL55
 */
public class CsvFileRepo {
    
    //connecteren Met database
     public static final String LOGIN = "root";
    public static final String PASSWORD = "root";
    public  static String DRIVER = "com.mysql.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/clientdb?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    
    
    String Titel = null,  Locatie= null, Straat = null, nr = null, Postcode = null;
    //constructor

    public CsvFileRepo() {
        this(URL);
    }
    

    protected CsvFileRepo(String url) {
        URL = url;
    }
    
    private Connection creatConnection()throws SQLException{
        conn = DriverManager.getConnection(URL,LOGIN,PASSWORD);
        //Statement = conn.createStatement();
    return conn ;
    }
    
    //methode Voor Write
    public void writeCsvFile(){
        
    }
    
    //methode print
    public void printCsvFile(){
        
    }
    
    
    
    //methode update
    public void updataCsvFile(){
        
    }
    
    //display the table
    
    //insert in DB
    /*public void insert(String){
    
    }*/
    
    
    
    
}
