/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.AnswerItemModel;
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
    private ResponseView instanceView;// = ResponseView.getInstance();
    private ArrayList<AnswerItemModel> answers; //= new int[instanceView.getTasks().size()-1][3];
    private int idParticipant;
    private QuestionnaireModel questionnaire;
    
    private ResponseControl(){
        
    }
    
    public static ResponseControl getInstance() {
        return singleton;
    }    
    public ResponseView getInstanceView() {
        return instanceView;
    }
    public void setInstanceView(ResponseView instanceView) {
        this.instanceView = instanceView;
    }
    public QuestionnaireModel getQuestionnaire() {
        return this.questionnaire;
    }
    //------------------------------------------------------------------------//
    
    private void updateQuestion(int taskNumber){
        int index = taskNumber-1;
        TaskModel task = questionnaire.getTasks().get(index);
        instanceView.updateView(task.getName(),taskNumber);
    }
    private void restoreResponsesToScales(int taskNumber){
        int index = taskNumber-1;
        TaskModel task = questionnaire.getTasks().get(index);
        instanceView.updateView(task.getName(),taskNumber);
    }
    private void conclude(){
        int op= JOptionPane.showConfirmDialog(null,"Confirmar respotas?",null ,JOptionPane.YES_NO_OPTION);
        if(op==0){   
            ResearcherModel.getInstance().registerAnswer(instanceView.getQuestionnaire(), answers, idParticipant);
            JOptionPane.showMessageDialog(null, "Resposta salva!");
            close();
        }
    }
    private boolean answered() { 
        return instanceView.isAnswered();
    }
    private void registerAnswer(int taskNumber) {
        if(answers.size()>0 && taskNumber<=answers.size()){
            answers.set(taskNumber-1, instanceView.getAnswers());
        }else{
            answers.add(instanceView.getAnswers());
        }
    }
    private boolean lastQuestion(int taskNumber){
        return taskNumber==instanceView.getTasks().size();
    }
    
//----------------------------------------------------------------------------//
 
    public void start(QuestionnaireModel questionnaire, int id) {
        this.idParticipant=id;
        this.questionnaire=questionnaire;
        this.answers = new ArrayList<>();
        ResponseView.main(null);
        this.instanceView = ResponseView.getInstance();
    }
    public void advance(int currentTask){
        if(answered()){
            registerAnswer(currentTask);
            if(lastQuestion(currentTask)){      
                conclude();
            }else{
                updateQuestion(currentTask+1);
            }
        }else{
          JOptionPane.showMessageDialog(null, "É necessário responder todas as escalas para prosseguir.");
        }
    }
    public void back(int currentTask){
        if(currentTask>1)
            restoreResponsesToScales(currentTask-1);               
    }
    public void cancel() {
        close();
    }
    public void close(){
        instanceView.close();
        MainControl.getInstance().showView();
    }
}
 
   /* public void showView(QuestionnaireModel questionnaire) {
        
        if(questionnaire.getTasks().size()>0){
            this.answers = new ArrayList<>();
            this.questionnaire=questionnaire;
            this.instanceView = ResponseView.main(null, questionnaire);
            instanceView.setEnabled(false);
            InsertIdControl.getInstance().showView();
           
        }   
    }*/
/*   private boolean checkAnswers() {
        //return instanceView.;
        return false;
    }
*/
//  public int[][] getAnswers() {
  //      return answers;
   // }

  //  public void setAnswers(int[][] answers) {
   //     this.answers = answers;
   // }