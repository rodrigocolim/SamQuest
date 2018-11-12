/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.TaskModel;
import Model.Questionnaire.QuestionnaireModel;
import Model.User.ResearcherModel;
import Utilities.PDFManipulator;
import View.VisualizationQuestionnaireView;

/**
 *
 * @author rodri
 */
public class VisualizationQuestionnaireControl {
    private static VisualizationQuestionnaireControl singleton = new VisualizationQuestionnaireControl();
    private QuestionnaireModel questionnaire;
    
    private VisualizationQuestionnaireControl(){
        
    }
    
    public static VisualizationQuestionnaireControl getInstance(){
        return singleton;
    }

    void showView(QuestionnaireModel questionnaire) {
        this.questionnaire=questionnaire;
        PDFManipulator.generatePDFQeestionnaire(questionnaire, getPath());
        VisualizationQuestionnaireView.main(null);
    }
    public void back(){
        TasksControl.getInstance().showView(questionnaire);
    }
    public void cancel() {
        MainControl.getInstance().showView();
    }
    public void conclude() {
        MainControl.getInstance().showView();
    }

    public void save() {
        ResearcherModel.getInstance().saveQuestPDF(questionnaire);
    }

    public String getPath() {
        return "Pre_Ready/"+questionnaire.getApplication()+".pdf";
    }
}
