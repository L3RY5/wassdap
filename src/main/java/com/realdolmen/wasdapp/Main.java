package com.realdolmen.wasdapp;
import com.realdolmen.domain.CsvFile;
import com.realdolmen.exception.CsvException;
import com.realdolmen.repositories.CsvFileRepo;
import com.realdolmen.services.CsvService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException ,SQLException{
        
        
       /* Scanner scanner = new Scanner(new File("C:/Users/SMTBM06/Desktop/StageNov-master/wassdap/Import-Sheet1.csv"));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+" | ");
        }
        scanner.close();*/
       //CsvFile csv1 = new CsvFile("SSS");
       CsvService csvService = new CsvService(new CsvFileRepo());
       //csvService.readCsvFile();
       csvService.AddMovie(csvService.readCsvFile());
       
    }
}
