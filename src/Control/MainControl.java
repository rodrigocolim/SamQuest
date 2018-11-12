/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.QuestionnaireModel;
import Model.User.ResearcherModel;
import View.CreateView;
import View.MainView;
import java.util.ArrayList;

/**
 *
 * @author rodri
 */
public class MainControl {
    private static final MainControl singleton = new MainControl();
    
    
    private MainControl(){
        
    }
    public static MainControl getInstance(){
        return singleton;
    }
    //------------------------------------------------//
    public void start(){
        MainView.getViewSingleton().main(null);
    }
    public void showView(){
        MainView.getViewSingleton().setVisible(true);
        MainView.getViewSingleton().updateQuestionnaires();
    }
    public void advanceToNextView() {
        CreateControl.getInstance().showView();
    }
    public ArrayList<QuestionnaireModel> getQuestionnaires(){
        return ResearcherModel.getInstance().getQuestionnaires();
    }
    
//-----------------------------------------------//

    public void close() {
        MainView.getViewSingleton().setVisible(false);
    }
}
