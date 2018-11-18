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
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
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
import com.itextpdf.text.Font;
import java.util.ArrayList;

public class PDFManipulator {

//*****************************************************************************//
    public static void generatePDFResults(QuestionnaireModel questionnaire, int[][][] results, String path) {
        Document document = new Document();
        try {
            FileOutputStream out = new FileOutputStream(path);
            PdfWriter.getInstance(document, out);
            document.open();

            createPDFHeaderOfResults(document, questionnaire.getApplication());
            createResultsTable(document, questionnaire, results);
            createCaptionForTable(document);

            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println(" erro " + e.getMessage());
        } catch (IOException e) {
            System.out.println(" erro " + e.getMessage());
        }
    }

    private static void createPDFHeaderOfResults(Document document, String application) throws DocumentException {
        Paragraph paragraph;
        Font font = new Font(Font.FontFamily.HELVETICA, (float) 14.0, Font.BOLD, new BaseColor(0, 0, 0));

        String title = ("Resultado Quantitativo do Questionário SAM");
        document.addTitle(title);
        paragraph = new Paragraph(title, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
       
        String subTitle = "Objeto de estudo: " + application;
        paragraph = new Paragraph(subTitle, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
        
        document.add(new Paragraph("\n"));
    }

    private static void createResultsTable(Document document, QuestionnaireModel questionnaire, int[][][] results) throws DocumentException {
        PdfPTable tabela = new PdfPTable(10);
        tabela.addCell("-");
        setDimensionsNames(tabela);
        tabela.addCell("-");
        setThePolarityOfTheResponse(tabela);
        setResults(tabela, results, questionnaire);
        document.add(tabela);
    }

    private static void createCaptionForTable(Document document) throws DocumentException {
        Paragraph paragraph;
        Font font = new Font(Font.FontFamily.HELVETICA, (float) 8.0, Font.NORMAL, new BaseColor(0, 0, 0));
        String caption = "AV- -> Avaliações Negativas";
        paragraph = new Paragraph(caption, font);
        document.add(paragraph);
        caption = "AV0 -> Avaliações Neutras";
        paragraph = new Paragraph(caption, font);
        document.add(paragraph);
        caption = "AV+ -> Avaliações Positivas";
        paragraph = new Paragraph(caption, font);
        document.add(paragraph);
    }

    private static void setDimensionsNames(PdfPTable tabela) {
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
    }

    private static void setThePolarityOfTheResponse(PdfPTable tabela) {
        for (int i = 0; i < 3; i++) {
            tabela.addCell("AV+");
            tabela.addCell("AV0");
            tabela.addCell("AV-");
        }
    }

    private static void setResults(PdfPTable tabela, int[][][] results, QuestionnaireModel questionnaire) {
        for (int x = 0; x < questionnaire.getTasks().size(); x++) {
            tabela.addCell("T" + (x + 1));
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    PdfPCell res = new PdfPCell(new Paragraph("" + results[x][y][z]));
                    tabela.addCell(res);
                }
            }
        }
    }
//*****************************************************************************//

    public static void generatePDFQeestionnaire(QuestionnaireModel questionnaire, String path) {
        Document document = new Document();
        try {
            FileOutputStream out = new FileOutputStream(path);
            PdfWriter.getInstance(document, out);
            document.open();

            createQuestionnairePDFHeader(questionnaire.getApplication(), document);
            createQuestionsInPDFQuestionnaire(questionnaire.getTasks(), document);

            document.addCreator("TUXE");
            document.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (DocumentException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createQuestionnairePDFHeader(String application, Document document) throws DocumentException {
        String title = "QUESTIONÁRIO SAM - " + application;
        document.addTitle(title);
        Paragraph paragraph;
        Font font = new Font(Font.FontFamily.HELVETICA, (float) 14.0, Font.BOLD, new BaseColor(0, 0, 0));
        paragraph = new Paragraph(title, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
    }

    private static void createQuestionsInPDFQuestionnaire(ArrayList<TaskModel> tasks, Document document) throws DocumentException, BadElementException, IOException {
        int taskNumber = 1;
        for (TaskModel task : tasks) {
            createQuestion(taskNumber, task, document);
            taskNumber++;
            document.add(new Paragraph("\n"));
        }
    }

    private static void createQuestion(int taskNumber, TaskModel task, Document document) throws DocumentException, BadElementException, IOException {
        createQuestionTitle(taskNumber, task.getName(), document);
        createScaleForEachDimension(task.getDimensions(), document);
        
    }

    private static void createScaleForEachDimension(DimensionProductModel[] dimensions, Document document) throws DocumentException, BadElementException, IOException {
        Paragraph paragraph ;
        for (DimensionProductModel dimension : dimensions) {
            paragraph = new Paragraph(dimension.getStatement());
            document.add(paragraph);
            Image image = Image.getInstance(dimension.getScale());
            document.add(image);
        }
    }

    private static void createQuestionTitle(int taskNumber, String name, Document document) throws DocumentException {
         String title = "Tarefa " + taskNumber + " - " + name;
        document.add(new Paragraph(title));
    }

}
