
package com.realdolmen.services;


import com.google.zxing.WriterException;
import com.realdolmen.repositories.CsvFileRepo;
import java.awt.image.BufferedImage;

        
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author YLOBL55
 */
public class CsvService {
    private CsvFileRepo csvRepo;

    public CsvService(CsvFileRepo csvRepo) {
        this.csvRepo = csvRepo;
    }

    public CsvService() {
      
    }    
    

//methode voor read
    public List<String[]> readCsvFile( ) throws FileNotFoundException, IOException{
       return csvRepo.displayCsv();
    }
    
   
    
    //voegTioe
    //all in one
    public void insertInTable(List<String[]> csv) throws SQLException, WriterException, IOException, InterruptedException{

         csvRepo.allInOne(csv);
    }
    
    /*
     1) convverts the imges to pdf
    */
    public void convertImgToPDF(String imagePath, String fileName, String destDir, PDDocument document) throws IOException {
        //PDDocument document = new PDDocument();
        InputStream in = new FileInputStream(imagePath);
        BufferedImage bimg = ImageIO.read(in);
        float width = bimg.getWidth();
        float height = bimg.getHeight();
        PDPage page = new PDPage(new PDRectangle(width, height));
        document.addPage(page);
        PDImageXObject img = PDImageXObject.createFromFile(imagePath, document);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.drawImage(img, 0, 0);
        contentStream.close();
        in.close();
       
    }
       
        


        
}
