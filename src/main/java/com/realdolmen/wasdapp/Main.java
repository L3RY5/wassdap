package com.realdolmen.wasdapp;
import com.realdolmen.repositories.CsvFileRepo;
import com.realdolmen.services.CsvService;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import com.google.zxing.WriterException;
import java.io.IOException;




public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException ,SQLException, WriterException, InterruptedException{
        
       //C:/Users/YLOBL55/Documents/GitHub/wassdap/Import-Sheet1.csv
        
       
       /*
    1) chech if file is csv. until it is ask for a csv file.
    2) maka a 2 dimensional array of the content of the csv file
    3)display it to show the file content
    
    */
       CsvService csvService = new CsvService(new CsvFileRepo());
       
    /*   all in one
    1) Remove data in Table
    2) takes the first item(Titel) of each row of 2demensional Array and create a QR-code 
    3) insert 2deminsionale Array in table (Row Per Row)
    4) display the insertion per row
    
     
    */
    
      csvService.insertInTable(csvService.readCsvFile());
    }
    
}
