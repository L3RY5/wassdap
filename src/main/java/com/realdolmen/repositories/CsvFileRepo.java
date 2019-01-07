
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
import java.nio.file.Files;
import java.nio.file.Paths;
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
    public  String path = "./QR/";
    CsvService service = new CsvService();
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
       
        return conn;
    }

    //methode Voor Write
    /*
    1) chech if file is csv. until it is ask for a csv file.
    2) maka a 2 dimensional array of the content of the csv file
    3)display it to show the file content
    
    */
    List<String[]> temp=null;
    public List<String[]> displayCsv() throws FileNotFoundException, IOException {
       
        try {
          Scanner in = new Scanner(System.in);
        System.out.print("Geef de pad naar uw CSV fille :  ");
        String path = in.next();
        while (!path.endsWith(".csv")) {
             System.out.print("CSV type A.U.B ! :  ");
              path = in.next();
        }
        System.out.print("\n");
        CSVReader reader2 = new CSVReader(new FileReader(path));
        List<String[]> myEntries = reader2.readAll();
        for (String[] kak : myEntries) {
            System.out.println(Arrays.toString(kak));
        }
         temp = myEntries;
        } catch (FileNotFoundException e) {
            System.err.print("File Not Found!\n"); 
            //System.exit(0);
            displayCsv();
            //throw  new FileNotFoundException("File Not found.");
        }
              
        
        return temp;

    }

   
    //display the table
    /*
    1) Remove data in Table
    2) takes the first item(Titel) of each row of 2demensional Array and create a QR-code
    3) insert 2deminsionale Array in table (Row Per Row)
    4) display the insertion per row
    */

    private static final String QR_CODE_IMAGE_PATH = "./img/MyQRCode";
    public void allInOne(List<String[]> csv) throws SQLException, WriterException, IOException, InterruptedException {
       
        connection=DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate("TRUNCATE stageproduct.stageproducttabel");
        Thread.sleep(1000);

        System.out.println("Clearing table\n");

        String query = "INSERT INTO stageproduct.stageproducttabel(Titel,Locatie,Straat,Nr,PostCode,Gemeente,Land,Omschrijven,WikipediaLink,Website,Telefoon,Email,Prijs,Persoon)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println("Pleas wait... connecting with DB\n");
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
                QRCodeGenerator.generateQRCodeImage(kak[0], 200, 200, QR_CODE_IMAGE_PATH + kak[0]+".png");
                
            }
            service.convertImgToPDF(QR_CODE_IMAGE_PATH + kak[0]+".png", kak[0], path, document);
            Files.deleteIfExists(Paths.get(QR_CODE_IMAGE_PATH + kak[0]+".png")); 
            
            preparedStatement.execute();
            
            pId++;
            Thread.sleep(1000);
       }
        document.save(path + "/" + "Producten" + ".pdf");
        document.close();

      
        System.out.println("Insertion Succecfull");
        preparedStatement.close();

    }

}
