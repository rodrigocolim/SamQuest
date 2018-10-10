/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.QuestionnaireModel;
import View.AddTaskView;
import View.ObjTask;
import View.TasksView;
import java.awt.Component;
import javax.swing.JLabel;

/**
 *
 * @author rodri
 */
public class TasksControl {
    private static final TasksControl singleton = new TasksControl();
    private QuestionnaireModel questionnaire;
   
    private TasksControl(){
        
    }
    
    public static TasksControl getInstance(){
        return singleton;
    }
    public void addTask(){
        //desabilitar pagina anterior
        new AddTaskView().main(null);
    }
     public void showView(QuestionnaireModel questionnaire) {
        //aqui salva o questionário onde as tarefas serão adicionadas a seguir
         this.questionnaire=questionnaire;
         // abre a view de tarefas
        TasksView.main(null);
    }

    public void close(TasksView aThis) {
        aThis.setVisible(false);
    }

    private String getString(Component[] components){
        for(Component c : components){
            if(c instanceof javax.swing.JLabel)
                return ((JLabel) c).getText();
        }
        return null;
    }
    public void createQuestionnaire(Component[] components) {
        //String[] tasks = new String[components.length];
        for(Component c: components){
            if(c instanceof ObjTask ){
                Component[] ObjTaskComponents = ((ObjTask) c).getComponents();
                questionnaire.getTasks().add(getString(ObjTaskComponents));
            }        
        }
        VisualizationControl.getInstance().show();
    }
}
