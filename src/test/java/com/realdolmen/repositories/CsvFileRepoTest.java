/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.repositories;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;



/**
 *
 * @author LJEBG43
 */
@RunWith(MockitoJUnitRunner.class)
public class CsvFileRepoTest {
    
    private CsvFileRepo Repo;
        private static String testURL = "jdbc:mysql://localhost:3306/stageproduct?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" ;
   
        @Mock
    private ResultSet resultSet;
        
        @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
         @Before
    public void init(){
       Repo  = new CsvFileRepo(testURL);
    }

    /**
     * Test of readCsvFile method, of class CsvFileRepo.
     * @throws java.sql.SQLException
     */
    @Test
    public void testDisplayCsv()throws SQLException{
        /*when(resultSet.getString("Title")).thenReturn("Koffiemachine");
        String[] result = Repo.displayCsv(resultSet);*/
        
    }

    /**
     * Test of insert.
     */
    @Test
    public void testInsert() {
      
    }


    @Test (expected = SQLException.class)
    public void findAllTestExceptionThrown() throws SQLException {
        Repo = new CsvFileRepo();
        when(resultSet.getString("title")).thenThrow(SQLException.class);
        
        Repo.insert((List<String[]>) resultSet);
        verify(resultSet, times(1)).getString("title");
    }

    
    
}
