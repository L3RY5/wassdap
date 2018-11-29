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
   // Connection conn = DriverManager.getConnection(URL,LOGIN,PASSWORD);
    PreparedStatement preparedStatement = null;
    
    
    String Titel = "sdsdd", Locatie= null, Straat = null, Nr = null, PostCode = null, Gemeente= null,Land=null,Omschrijven=null,WikipediaLink=null,Website=null,Telefoon=null,Email=null,Prijs=null,Persoon=null;
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
    public void insert(String titel,String locatie,String straat,String nr,String postcode,String gemeente,String land,String omschrijven,String wikipediaLinks,String website,String telefoon,String email,String prijs,String persoon) throws SQLException{
    String query = "INSERT INTO stageproduct.stageproducttabel(Titel,Locatie,Straat,Nr,PostCode,Gemeente,Land,Omschrijven,WikipediaLink,Website,Telefoon,Email,Prijs,Persoon)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";   
    System.out.println("Pleas wait... connecting with DB");
    conn = creatConnection();
     System.out.println("................................");
      System.out.println("Adding Data into DB");
    preparedStatement=conn.prepareCall(query);
    preparedStatement.setString(1, "Titel");
    preparedStatement.setString(2, "Locatie2");
    preparedStatement.setString(3, "Straat");
    preparedStatement.setString(4, "NrTest");
    preparedStatement.setString(5, "Locatie2");
    preparedStatement.setString(6, "Straat");
    preparedStatement.setString(7, "NrTest");
    preparedStatement.setString(8, "NrTest");
    preparedStatement.setString(9, "Locatie2");
    preparedStatement.setString(10, "Straat");
    preparedStatement.setString(11, "NrTest");
    preparedStatement.setString(12, "Locatie2");
    preparedStatement.setString(13, "Straat");
    preparedStatement.setString(14, "NrTest");
    preparedStatement.execute();
    System.out.println("Insertion Succecfull");
    preparedStatement.close();
     
    }
    
    
    
    
}
