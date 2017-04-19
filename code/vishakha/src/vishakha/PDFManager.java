/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vishakha;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

/**
 *
 * @author MMI
 */
public class PDFManager {
       private PDFParser parser;
   private PDFTextStripper pdfStripper;
   private PDDocument pdDoc ;
   private COSDocument cosDoc ;
   
   private String Text ;
   private String filePath;
   private File file;

    public PDFManager() {
        
    }
   public String ToText() throws IOException, CryptographyException, COSVisitorException
   {
       this.pdfStripper = null;
       this.pdDoc = null;
       this.cosDoc = null;
       
       file = new File(filePath);
       
       parser = new PDFParser(new FileInputStream(file)); // update for PDFBox V 2.0
       
       parser.parse();
       cosDoc = parser.getDocument();
       pdfStripper = new PDFTextStripper();
       pdDoc = new PDDocument(cosDoc);
       pdDoc.getNumberOfPages();
       //pdfStripper.setStartPage(1);
       //pdfStripper.setEndPage(1);
       
       // reading text from page 1 to 10
       // if you want to get text from full pdf file use this code
       // pdfStripper.setEndPage(pdDoc.getNumberOfPages());
       
       //Text = pdfStripper.getText(pdDoc);
       //return Text;
        try
        {
            //doc = PDDocument.load( "my.pdf" );
              Text = pdfStripper.getText(pdDoc);
              return Text;
        }
        finally
        {
            if( pdDoc != null )
            {
                pdDoc.close();
            }
        }
   }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
}
