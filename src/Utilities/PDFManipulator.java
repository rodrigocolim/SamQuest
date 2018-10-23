/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author rodri
 */
import Model.Builder.DimensionProductModel;
import Model.Questionnaire.QuestionnaireModel;
import Model.Questionnaire.TaskModel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;

public class PDFManipulator {
    
    
    public static void generatePDF(QuestionnaireModel questionnaire, String path) {
        // TODO Auto-generated method stub
        Document document = new Document();
        try {
            FileOutputStream out = new FileOutputStream("Questionnaires/"+questionnaire.getProjectName()+".pdf");
            PdfWriter.getInstance(document, out);
            document.open();
            Paragraph paragraph;
            //****************************************************************//
            paragraph = new Paragraph("Projeto: "+questionnaire.getProjectName());
            document.add(paragraph);
            paragraph = new Paragraph("Aplicativo: "+questionnaire.getApplication());
            document.add(paragraph);
            //****************************************************************//
            int taskNumber=1;
            for(TaskModel task: questionnaire.getTasks()){
                paragraph = new Paragraph("Tarefa "+taskNumber+" - "+task.getName());
                document.add(paragraph);
                for(DimensionProductModel dimension : task.getDimensions()){
                    paragraph = new Paragraph(dimension.getStatement());
                    document.add(paragraph);
                    Image image = Image.getInstance(dimension.getScale());
                    document.add(image);
                }
            }
            //****************************************************************//
            document.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // TODO Auto-generated catch block
         catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
