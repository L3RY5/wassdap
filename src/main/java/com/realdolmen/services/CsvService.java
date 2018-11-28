/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.services;

import com.realdolmen.domain.CsvFile;
import com.realdolmen.repositories.CsvFileRepo;

        
import java.io.File;
import java.io.FileNotFoundException;
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
    public void readCsvFile( ) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        System.out.print("Geef de pad naar uw CSV fille :  ");
        String path = in.next();
        Scanner scanner = new Scanner(new File(path));
        //Scanner scanner = new Scanner(new File("/Users/YLOBL55/Documents/GitHub/wassdap/Import-Sheet1.csv"));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+" | ");
        }
        scanner.close();
    }
}
