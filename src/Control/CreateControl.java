/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.QuestionnaireModel;
import Model.User.ResearcherModel;
import View.CreateView;

/**
 *
 * @author rodri
 */
public class CreateControl {
    private static final CreateControl singleton = new CreateControl();
    private static CreateView createView;
    
    private CreateControl (){
        
    }
    public static CreateControl getInstance(){
        return singleton;
    }
    //------------------------------------------------------------------------//
    public void showView(){
        CreateView.main(null);
    }
    public void cancel() {  
        MainControl.getInstance().showView();
    }
   public void advanceToNextView(QuestionnaireModel questionnaire){
       TasksControl.getInstance().showView(questionnaire);
   }
    public QuestionnaireModel createQuestionnaire(String name, String org, String app) {
        //intanciar o questionar sem tarefas, 
        //quando adicionarem as tarefas, o quest vai estar pronto
        return ResearcherModel.getInstance().createQuestionnaire(name, org, app);
        
    } 
}
