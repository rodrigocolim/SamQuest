/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.QuestionnaireModel;
import Model.User.ResearcherModel;
import View.RenameApplicationView;

/**
 *
 * @author rodri
 */
public class RenameApplicationControl {
    private static final RenameApplicationControl singleton = new RenameApplicationControl();
    private QuestionnaireModel questionnaire;
    
    private RenameApplicationControl() {
    }
    public static RenameApplicationControl getInstance(){
        return singleton;
    }
    public void showView(QuestionnaireModel questionnaire){
        this.questionnaire=questionnaire;
        RenameApplicationView.main(null, questionnaire.getApplication());
    }
    public void advanceToEditQuestionnaireView(String name) {
        ResearcherModel.getInstance().renameApplication(questionnaire, name);
        EditQuestionnaireControl.getInstance().updateView();
        EditQuestionnaireControl.getInstance().enableView();
    }
    public void cancelRenaming(){
        EditQuestionnaireControl.getInstance().enableView();
    }

    public QuestionnaireModel getQuestionnaire() {
        return questionnaire;
    }
}
