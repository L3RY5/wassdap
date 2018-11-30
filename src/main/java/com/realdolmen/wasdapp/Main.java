package com.realdolmen.wasdapp;
import com.realdolmen.repositories.CsvFileRepo;
import com.realdolmen.services.CsvService;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import com.google.zxing.WriterException;
import java.io.IOException;




public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException ,SQLException, WriterException, InterruptedException{
        
       /* Scanner scanner = new Scanner(new File("C:/Users/YLOBL55/Documents/GitHub/wassdap/Import-Sheet1.csv"));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+" | ");
        }
        scanner.close();*/
       //CsvFile csv1 = new CsvFile("SSS");
      
       
       CsvService csvService = new CsvService(new CsvFileRepo());
       //csvService.readCsvFile();
       csvService.insertInTable(csvService.readCsvFile());
    }
    
}
