/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.exception;

/**
 *
 * @author YLOBL55
 */

    
    public class CsvException extends Exception {

    private static final String MESSAGE = "There is no query possible here";

    public CsvException() {
        super(MESSAGE);
    }
    
    
    
    }
