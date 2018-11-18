/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.QuestionnaireModel;
import Model.User.ResearcherModel;
import Utilities.PDFManipulator;
import View.VisualizationQuestionnaireView;

/**
 *
 * @author rodri
 */
public class VisualizationQuestionnaireControl {

    private static final VisualizationQuestionnaireControl singleton = new VisualizationQuestionnaireControl();
    private QuestionnaireModel questionnaire;

    private VisualizationQuestionnaireControl() {

    }

    public static VisualizationQuestionnaireControl getInstance() {
        return singleton;
    }

    //-------------------------------------------------------------------------//
    public void showView(QuestionnaireModel questionnaire) {
        this.questionnaire = questionnaire;
        PDFManipulator.generatePDFQeestionnaire(questionnaire, getPath());
        VisualizationQuestionnaireView.main(null);
    }

    public void backToEditQuestionnaireView() {
        EditQuestionnaireControl.getInstance().showView(questionnaire);
    }

    public void cancelEdition() {
        MainControl.getInstance().showView();
    }

    public void concludeEdition() {
        MainControl.getInstance().showView();
    }

    public void savePDFQuestionnaire() {
        ResearcherModel.getInstance().saveQuestPDF(questionnaire);
    }

    public String getPath() {
        return "Pre_Ready/" + questionnaire.getApplication() + ".pdf";
    }
}
