package com.realdolmen.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Rectangle;
import java.io.FileOutputStream;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import javax.swing.text.Document;

/**
 *
 * @author SMTBM06
 */
public class QRCodeGenerator {
    
   

    public static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    
}
