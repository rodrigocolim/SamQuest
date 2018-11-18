/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.QuestionnaireModel;
import Model.User.ResearcherModel;
import Utilities.PersistenceController;
import View.MainView;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    //------------------------------------------------------------------------//
  
    public void start(){
        MainView.getInstance().main(null);
    }
    public void showView(){
        MainView.getInstance().setVisible(true);
        MainView.getInstance().setEnabled(true);
        MainView.getInstance().updateQuestionnaires();
    }
    public void startCreation() {
        DefineApplicationControl.getInstance().showView();
    }
    public ArrayList<QuestionnaireModel> getQuestionnaires(){
        return ResearcherModel.getInstance().getQuestionnaires();
    }
    public void closeMainView() {
        MainView.getInstance().setVisible(false);
    }
    public void delete(QuestionnaireModel questionnaire) {
        String message = "Deseja excluir o questionário de "+questionnaire.getApplication()+"?";
        int op = JOptionPane.showConfirmDialog(null, message, null, JOptionPane.YES_NO_OPTION);
        if(op==0){
            ResearcherModel.getInstance().deleteQuestionnaire(questionnaire);
            JOptionPane.showMessageDialog(null, "Questionário excluído!");
            MainView.getInstance().updateQuestionnaires();   
        }
    }

    public void disableMainView() {
        MainView.getInstance().disable();
    }
}
