/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.QuestionnaireModel;
import Model.Questionnaire.TaskModel;
import Model.User.ResearcherModel;
import View.EditQuestionnaireView;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class EditQuestionnaireControl {

    private static final EditQuestionnaireControl singleton = new EditQuestionnaireControl();
    private QuestionnaireModel questionnaire;

    private EditQuestionnaireControl() {

    }

    public static EditQuestionnaireControl getInstance() {
        return singleton;
    }

    //------------------------------------------------------------------------//
    private boolean confirmedTaskDeletion() {
        int op = JOptionPane.showConfirmDialog(null, "Deseja excluir esta tarefa?", null, JOptionPane.YES_NO_OPTION);
        return op == 0;
    }
    
    public void showView(QuestionnaireModel questionnaire) {
        //aqui salva o questionário onde as tarefas serão adicionadas a seguir
        this.questionnaire = questionnaire;
        // abre a view de tarefas
        EditQuestionnaireView.main(null);
    }

    public void renameApplication() {
        RenameApplicationControl.getInstance().showView(questionnaire);
    }

    public void cancelEditionOfTheQuestionnaire() {
        MainControl.getInstance().showView();
    }

    public void addTask() {
        //desabilitar pagina anterior
        AddTaskControl.getInstance().showView(questionnaire);
    }

    public void advanceToVisualizationQuestionnaireView() {
        //chama view de pré-visualização
        VisualizationQuestionnaireControl.getInstance().showView(questionnaire);
        //criar questões lá no proximo controle
    }

    public void updateView() {
        EditQuestionnaireView.getInstance().updateView();
    }

    //a partir deste questionário, a view exibirá as tarefas
    public QuestionnaireModel getQuestionnaire() {
        return this.questionnaire;
    }

    public void deleteTask(TaskModel task) {
        if (confirmedTaskDeletion()) {
            ResearcherModel.getInstance().deleteTask(questionnaire, task);
            updateView();
        }
    }

    public void renameTask(TaskModel task) {
        EditQuestionnaireView.getInstance().enable(false);
        RenameTaskControl.getInstance().showView(task);
    }

    public void enableView() {
        EditQuestionnaireView.getInstance().enable(true);
        EditQuestionnaireView.getInstance().show();
    }

    public void concludeEdition() {
        MainControl.getInstance().showView();
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
