/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.repositories;

import com.google.zxing.WriterException;
import com.opencsv.CSVReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.realdolmen.domain.QRCodeGenerator;
import com.realdolmen.services.CsvService;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author YLOBL55
 */
public class CsvFileRepo {

    //connecteren Met database
    public static final String LOGIN = "root";
    public static final String PASSWORD = "root";
    public static String DRIVER = "com.mysql.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/stageproduct?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    Connection conn = null;
    Connection connection =null;
    PDDocument document = new PDDocument();
    public  String path = "./here/";
    CsvService service = new CsvService();
    // Connection conn = DriverManager.getConnection(URL,LOGIN,PASSWORD);
    PreparedStatement preparedStatement = null;

    
    //constructor

    public CsvFileRepo() {
        this(URL);
    }

    protected CsvFileRepo(String url) {
        URL = url;
    }

    private Connection creatConnection() throws SQLException {
        conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        //Statement = conn.createStatement();
        return conn;
    }

    //methode Voor Write
    public List<String[]> displayCsv() throws FileNotFoundException, IOException {

        Scanner in = new Scanner(System.in);
        System.out.print("Geef de pad naar uw CSV fille :  ");
        String path = in.next();
        CSVReader reader2 = new CSVReader(new FileReader(path));
        //Scanner  = new Scanner(new File(path));
        List<String[]> myEntries = reader2.readAll();
        for (String[] kak : myEntries) {
            System.out.println(Arrays.toString(kak));
        }
        return myEntries;

    }

    //methode print
    public void printCsvFile() {

    }

    //methode update
    public void updataCsvFile() {

    }

    //display the table
    //insert  en/of Update de  DB

    private static final String QR_CODE_IMAGE_PATH = "./MyQRCode";
    public void insert(List<String[]> csv) throws SQLException, WriterException, IOException, InterruptedException {

        connection=DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate("TRUNCATE stageproduct.stageproducttabel");
        Thread.sleep(1000);

        System.out.println("Clearing table");

        String query = "INSERT INTO stageproduct.stageproducttabel(Titel,Locatie,Straat,Nr,PostCode,Gemeente,Land,Omschrijven,WikipediaLink,Website,Telefoon,Email,Prijs,Persoon)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println("Pleas wait... connecting with DB");
        conn = creatConnection();
        
        System.out.println("Adding Data into DB");
        Thread.sleep(1000);
     

        preparedStatement = conn.prepareCall(query);
        int pId=1;
        csv.remove(0);
        for (String[] kak : csv) {

             
            System.out.println("..........................Product ID " +pId +"......................");
            
            for (int i = 0; i < kak.length; i++) {
                
                System.out.println(kak[i]);
                preparedStatement.setString(i+1, kak[i]);
                QRCodeGenerator.generateQRCodeImage(kak[0], 350, 350, QR_CODE_IMAGE_PATH + kak[0]+".png");
                
            }
            service.convertImgToPDF(QR_CODE_IMAGE_PATH + kak[0]+".png", kak[0], path, document);
            
            preparedStatement.execute();
            
            pId++;
            Thread.sleep(2000);
       }
        document.save(path + "/" + "test" + ".pdf");
        document.close();

      
        System.out.println("Insertion Succecfull");
        preparedStatement.close();

    }

}
