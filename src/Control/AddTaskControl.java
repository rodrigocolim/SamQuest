/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.QuestionnaireModel;
import Model.User.ResearcherModel;
import View.AddTaskView;
/**
 *
 * @author rodri
 */
public class AddTaskControl {
    private QuestionnaireModel questionnaire;
    private static final AddTaskControl singleton = new AddTaskControl(); 
    
    private AddTaskControl(){
        
    }
    public static AddTaskControl getInstance(){
        return singleton;
    }
    public void addTask(String nomeTask){
        ResearcherModel.getInstance().addTask(nomeTask, questionnaire);
        EditQuestionnaireControl.getInstance().enableView();
        EditQuestionnaireControl.getInstance().updateView();
    }

    public void showView(QuestionnaireModel questionnaire) {
        this.questionnaire=questionnaire;
        AddTaskView.main(null);
    }
    public void cancelTaskAddition(){
        EditQuestionnaireControl.getInstance().enableView();
    }
   
}
