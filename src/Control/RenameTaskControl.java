/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.TaskModel;
import Model.User.ResearcherModel;
import View.RenameTaskView;

/**
 *
 * @author rodri
 */
public class RenameTaskControl {
    private static final RenameTaskControl singleton = new RenameTaskControl();
    private TaskModel task;
    private RenameTaskControl() {
    }
    public static RenameTaskControl getInstance(){
        return singleton;
    }

    public void renameTask(String text) {
        ResearcherModel.getInstance().renameTask(task, text);
        EditQuestionnaireControl.getInstance().updateView();
    }

    void showView(TaskModel task) {
        RenameTaskView.main(null, task.getName());
        this.task=task;
    }

    public void cancelRenaming() {
        EditQuestionnaireControl.getInstance().enableView();
    }
    
}
