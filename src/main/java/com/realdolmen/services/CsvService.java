/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.services;

import com.opencsv.CSVReader;
import com.realdolmen.domain.CsvFile;
import com.realdolmen.repositories.CsvFileRepo;

        
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author YLOBL55
 */
public class CsvService {
    private CsvFileRepo csvRepo;

    public CsvService(CsvFileRepo csvRepo) {
        this.csvRepo = csvRepo;
    }
    
    

//methode voor read
    public List<String[]> readCsvFile( ) throws FileNotFoundException, IOException{
       return csvRepo.displayCsv();
    }
    
   /*// Method insert into DB
    public  void fillDb(List<String[]> csv){
                for (String[] kak : csv) {
            System.out.println(Arrays.toString(kak));
        }
    }   */
    
    
    //voegTioe
    public void AddMovie(List<String[]> csv) throws SQLException{
         csvRepo.insert(csv);
    }
       
        


        
}
