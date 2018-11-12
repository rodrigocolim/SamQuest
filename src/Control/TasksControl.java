/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.QuestionnaireModel;
import Model.Questionnaire.TaskModel;
import Model.User.ResearcherModel;
import View.AddTaskView;
import View.Objects.ObjTask;
import View.TasksView;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;

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
    //------------------------------------------------------------------------//
    public void showView(QuestionnaireModel questionnaire) {
        //aqui salva o questionário onde as tarefas serão adicionadas a seguir
        this.questionnaire=questionnaire;
        // abre a view de tarefas
        TasksView.main(null);
    }
    public void back() {
        CreateControl.getInstance().showView();
    }
    public void cancel() {
        MainControl.getInstance().showView();
    }
    public void addTask(){
        //desabilitar pagina anterior
        AddTaskControl.getInstance().showView(questionnaire);
    }
    public void advanceToNextView(){
        //chama view de pré-visualização
        VisualizationQuestionnaireControl.getInstance().showView(questionnaire);
        //criar questões lá no proximo controle
    }
    public void updateJPanel(){
        TasksView.getSingletonView().showTasks();
    }
    //a partir deste questionário, a view exibirá as tarefas
    public QuestionnaireModel getQuestionnaire(){
        return this.questionnaire;
    }   


    public void delete(TaskModel task) {
        if(confirmed()){
            ResearcherModel.getInstance().deleteTask(questionnaire, task);
            updateJPanel();
        }
    }

    public void rename(TaskModel task) {
        
        RenameTaskControl.getInstance().showView(task);
    }

    private boolean confirmed() {
        int op = JOptionPane.showConfirmDialog(null, "Deseja excluir esta tarefa?", null ,JOptionPane.YES_NO_OPTION);
        return op==0;
    }

    
}

/*  public void addTasks(Component[] components) {
        //String[] tasks = new String[components.length];
        //pegando as tarefas que foram adicionadas na view e adicionando ao questionario.
        for(Component c: components){
            if(c instanceof ObjTask ){
                Component[] ObjTaskComponents = ((ObjTask) c).getComponents();
                ResearcherModel.getInstance().addTask(getString(ObjTaskComponents), questionnaire);
            }        
        }
        //chama view de pré-visualização
        VisualizationQuestionnaireControl.getInstance().show(questionnaire);
        
    }

private String getString(Component[] components){
        for(Component c : components){
            if(c instanceof javax.swing.JLabel)
                return ((JLabel) c).getText();
        }
        return null;
    }

*/