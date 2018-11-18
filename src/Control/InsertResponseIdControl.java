/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.AnswerModel;
import Model.Questionnaire.QuestionnaireModel;
import View.InsertResponseIdView;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class InsertResponseIdControl {
    private static final InsertResponseIdControl singleton = new InsertResponseIdControl();
    private QuestionnaireModel questionnaire;
    
    private InsertResponseIdControl(){
        
    }
    
    public static InsertResponseIdControl getInstance(){
        return singleton;
    } 
    
    public void showView(QuestionnaireModel questionnaire){
        this.questionnaire=questionnaire;
        InsertResponseIdView.main(null);
    }
    public void advanceToResponseView(int id){
        if(isIdValid(id)){
            ResponseControl.getInstance().start(questionnaire,id);
            MainControl.getInstance().closeMainView();
        }else{
            JOptionPane.showMessageDialog(null, "Uma resposta já foi cadastrada com este identificador!");
        }
    }
    private boolean isIdValid(int id) {
        for(AnswerModel aux : questionnaire.getResults()){
            if (aux.getIdParticipant()==id){             
                return false;
            }
        }
        return true;
    }
    public void cancelReply() {
        MainControl.getInstance().showView();
    }
}
