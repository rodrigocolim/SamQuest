/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.TaskModel;
import Model.Questionnaire.QuestionnaireModel;
import View.VisualizationView;

/**
 *
 * @author rodri
 */
public class VisualizationControl {
    private static VisualizationControl singleton = new VisualizationControl();
    private QuestionnaireModel questionnaire;
    
    private VisualizationControl(){
        
    }
    
    public static VisualizationControl getInstance(){
        return singleton;
    }

    void showView(QuestionnaireModel questionnaire) {
        this.questionnaire=questionnaire;
        //o questionário possui tarefas apenas com nomes
        //precisa gerar os prodcut dimenions
        //e então tranformar em pdf e mostrar
        VisualizationView.main(null);
    }
    public void back(){
        TasksControl.getInstance().showView(questionnaire);
    }
    public void cancel() {
        MainControl.getInstance().showView();
    }
    public void conclude() {
        MainControl.getInstance().showView(questionnaire);
    }
}
