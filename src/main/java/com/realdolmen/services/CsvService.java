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
    public void readCsvFile( ) throws FileNotFoundException, IOException{
        Scanner in = new Scanner(System.in);
        System.out.print("Geef de pad naar uw CSV fille :  ");
        String path = in.next();
        CSVReader reader2 = new CSVReader(new FileReader(path));
        //Scanner  = new Scanner(new File(path));
        List<String[]> myEntries = reader2.readAll();
        for (String[] kak : myEntries) {
            System.out.println(Arrays.toString(kak));
        }
    }
    
    
    //voegTioe
    public void AddMovie(CsvFile csvFile) throws SQLException{
         csvRepo.insert("titel","locatie","straat","nr","postcode","gemeente","land","omschrijven","wikipediaLinks","website","telefoon","email","prijs","persoon");
    }
       
        


        
}
