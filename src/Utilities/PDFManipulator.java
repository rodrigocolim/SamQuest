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
import Model.Questionnaire.AnswerItemModel;
import Model.Questionnaire.AnswerModel;
import Model.Questionnaire.QuestionnaireModel;
import Model.Questionnaire.TaskModel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.common.ComponentKeyBinding;

public class PDFManipulator {

    public static void generatePDFQeestionnaire(QuestionnaireModel questionnaire, String path) {
        // TODO Auto-generated method stub
        Document document = new Document();
        try {
            FileOutputStream out = new FileOutputStream(path);
            PdfWriter.getInstance(document, out);
            document.open();
            Paragraph paragraph;
            //****************************************************************//
            paragraph = new Paragraph("Projeto: " + questionnaire.getProjectName());
            document.add(paragraph);
            paragraph = new Paragraph("Aplicativo: " + questionnaire.getApplication());
            document.add(paragraph);
            //****************************************************************//
            int taskNumber = 1;
            for (TaskModel task : questionnaire.getTasks()) {
                paragraph = new Paragraph("Tarefa " + taskNumber + " - " + task.getName());
                document.add(paragraph);
                for (DimensionProductModel dimension : task.getDimensions()) {
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
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // TODO Auto-generated catch block
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void generatePDFResults(QuestionnaireModel questionnaire, int[][][] results, String path) {
        Document document = new Document();
        try {
            FileOutputStream out = new FileOutputStream(path);
            PdfWriter.getInstance(document, out);
            document.open();
            Paragraph paragraph;
            //*****************************************************************//
            paragraph = new Paragraph("Resultado Quantitativo do Questionário SAM");
            document.add(paragraph);
            paragraph = new Paragraph("Aplicativo: " + questionnaire.getApplication());
            document.add(paragraph);
            //*****************************************************************//
            PdfPTable tabela = new PdfPTable(10);

            tabela.addCell("-");

            PdfPCell c = new PdfPCell(new Paragraph("Satisfação"));
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c.setColspan(3);
            tabela.addCell(c);

            PdfPCell c1 = new PdfPCell(new Paragraph("Dominio"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setColspan(3);
            tabela.addCell(c1);

            PdfPCell c2 = new PdfPCell(new Paragraph("Motivação"));
            c2.setHorizontalAlignment(Element.ALIGN_CENTER);
            c2.setColspan(3);
            tabela.addCell(c2);

            tabela.addCell("-");

            tabela.addCell("AV+");
            tabela.addCell("AV0");
            tabela.addCell("AV-");

            tabela.addCell("AV+");
            tabela.addCell("AV0");
            tabela.addCell("AV-");

            tabela.addCell("AV+");
            tabela.addCell("AV0");
            tabela.addCell("AV-");

            for (int x = 0; x < questionnaire.getTasks().size(); x++) {
                tabela.addCell("T"+(x+1));
                for (int y = 0; y < 3; y++) {
                    for (int z = 0; z < 3; z++) {
                        PdfPCell res = new PdfPCell(new Paragraph(""+results[x][y][z]));
                        tabela.addCell(res);
                    }
                }
            }
            
            document.add(tabela);
            //*****************************************************************//
            paragraph = new Paragraph("AV- -> Avaliações Negativas");
            document.add(paragraph);
            paragraph = new Paragraph("AV0 -> Avaliações Neutras");
            document.add(paragraph);
            paragraph = new Paragraph("AV+ -> Avaliações Positivas");
            document.add(paragraph);
            //*****************************************************************//
            document.close();
        } catch (DocumentException | FileNotFoundException e){
            System.out.println(" erro "+e.getMessage());
        }catch(IOException e) {
            System.out.println(" erro "+e.getMessage());
        }
    }
    

}
