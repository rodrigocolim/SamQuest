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
    
    private CreateControl (){
        
    }
    public static CreateControl getInstance(){
        return singleton;
    }

    public void cancel(CreateView aThis) {
       close(aThis);
        MainControl.show();
    }

   public void close(CreateView aThis){
        aThis.setVisible(false);
   }

    public void createQuestionnaire(String name, String org, String app) {
        //intanciar o questionar e abir a view de tarefas, 
        //quando adicionarem as tarefas, o quest vai estar pronto
        QuestionnaireModel questionnaire = 
            ResearcherModel.getInstance().createQuestionnaire(name, org, app);
        TasksControl.getInstance().showView(questionnaire);
    }

 
}
