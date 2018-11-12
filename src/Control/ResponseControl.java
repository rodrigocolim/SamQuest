/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.AnswerItemModel;
import Model.Questionnaire.AnswerModel;
import Model.Questionnaire.QuestionnaireModel;
import Model.Questionnaire.TaskModel;
import Model.User.ResearcherModel;
import View.ResponseView;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author rodri
 */
public class ResponseControl {
    private static final ResponseControl singleton = new ResponseControl();
    private ResponseView instanceView ;
    private ArrayList<AnswerItemModel> answers; //= new int[instanceView.getTasks().size()-1][3];
    private int idParticipant;
    private QuestionnaireModel questionnaire;
    public static ResponseControl getInstance() {
        return singleton;
    }
    
    private ResponseControl(){
        
    }
    
    //---------------------------------------------------//
     private void update(int taskNumber){
        int index = taskNumber-1;
        TaskModel task = questionnaire.getTasks().get(index);
        instanceView.updateView(task.getName(),taskNumber);
    }
      private void restore(int taskNumber){
        int index = taskNumber-1;
        TaskModel task = questionnaire.getTasks().get(index);
        instanceView.updateView(task.getName(),taskNumber);
    }
     public void close(){
        instanceView.close();
        MainControl.getInstance().showView();
    }
     private void conclude(){
        int op= JOptionPane.showConfirmDialog(null,"Confirmar respotas?",null ,JOptionPane.YES_NO_OPTION);
        if(op==0){   
            ResearcherModel.getInstance().registerAnswer(instanceView.getQuestionnaire(), answers, idParticipant);
        //exibir confirmação
            close();
        }
    }
      private boolean checkAnswer() { 
        return instanceView.isAnswered();
    }

    private void registerAnswer(int taskNumber) {
        if(answers.size()>0 && taskNumber<=answers.size()){
            answers.set(taskNumber-1, instanceView.getAnswers());
        }else{
            answers.add(instanceView.getAnswers());
        }
    }
//---------------------------------------------------//
  
    public void showView(QuestionnaireModel questionnaire) {
        
        if(questionnaire.getTasks().size()>0){
            this.answers = new ArrayList<>();
            this.questionnaire=questionnaire;
            this.instanceView = ResponseView.main(null, questionnaire);
            instanceView.setEnabled(false);
            InsertIdControl.getInstance().showView();
           
        }   
    }
    public void start(int id) {
        this.idParticipant=id;
        instanceView.setEnabled(true);
        instanceView.setVisible(true);
    }
    public void advance(int currentTask){
        if(checkAnswer()){
            registerAnswer(currentTask);
            if(currentTask<instanceView.getTasks().size()){      
                update(currentTask+1);
            }else{
                conclude();
            }
        }else{
          //mostrar msg de erro // falta responder   
        }
    }
    public void back(int currentTask){
        if(currentTask>1)
            restore(currentTask-1);               
    }
   
    public void cancel() {
        close();
    }
    
    public boolean theresId(int id) {
        for(AnswerModel aux : questionnaire.getResults()){
            if (aux.getIdParticipant()==id){             
                return true;
            }
        }
        return false;
    }

  

 /*   private boolean checkAnswers() {
        //return instanceView.;
        return false;
    }
*/
  
//-----------------------------------------------

    public ResponseView getInstanceView() {
        return instanceView;
    }

    public void setInstanceView(ResponseView instanceView) {
        this.instanceView = instanceView;
    }

  //  public int[][] getAnswers() {
  //      return answers;
   // }

  //  public void setAnswers(int[][] answers) {
   //     this.answers = answers;
   // }

    public QuestionnaireModel getQuestionnaire() {
        return this.questionnaire;
    }

    

 
}
