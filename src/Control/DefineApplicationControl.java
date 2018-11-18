/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.QuestionnaireModel;
import Model.User.ResearcherModel;
import View.DefineApplicationView;

/**
 *
 * @author rodri
 */
public class DefineApplicationControl {
    private static final DefineApplicationControl singleton = new DefineApplicationControl();
    
    private DefineApplicationControl (){
        
    }
    public static DefineApplicationControl getInstance(){
        return singleton;
    }
    //------------------------------------------------------------------------//
    public void showView(){
        DefineApplicationView.main(null);
    }
    public void cancelQuestionnaireCreation() {  
        MainControl.getInstance().showView();
    }
   public void advanceToEditQuestionnaireView(String application){
       closePrevious();
       EditQuestionnaireControl.getInstance().showView(createQuestionnaire(application));
   }
    public QuestionnaireModel createQuestionnaire(String application) {
        return ResearcherModel.getInstance().createQuestionnaire(application);
    } 
    private void closePrevious() {
        MainControl.getInstance().closeMainView();
    }
}
