
package Model.User;

import Model.Questionnaire.AnswerItemModel;
import Model.Questionnaire.AnswerModel;
import Model.Questionnaire.QuestionnaireModel;
import Model.Questionnaire.TaskModel;
import Utilities.PDFManipulator;
import com.itextpdf.text.DocumentException;
import java.io.Serializable;
import java.util.ArrayList;

public class ResearcherModel implements Serializable {
    private String name;
    private String email;
    private String password;
    private ArrayList<QuestionnaireModel> questionnaires = new ArrayList<>();
    //mudar para receber o pesquisador da persistência
    private static final ResearcherModel singleton = new ResearcherModel();
    
    private ResearcherModel(){
        this.questionnaires = new ArrayList<QuestionnaireModel>();
    }
    
    public void editQuestionnaire(){
        
    }
 //   public void answerQuestionnaire(){ 
 //   }
    public void deleteQuestionnaire(){
    
    }
    public void addTask(String nameTask, QuestionnaireModel questionnaire){
        questionnaire.getTasks().add(new TaskModel(nameTask));
    } 
    public void organizeTasks(){
        
    }
    public void saveQuestPDF(QuestionnaireModel questionnaire){
        String path = "Questionnaires/"+questionnaire.getProjectName()+".pdf";
        PDFManipulator.generatePDFQeestionnaire(questionnaire, path);
    }
    public void saveResultPDF(QuestionnaireModel questionnaire)throws DocumentException{
        String path = "Results/" + questionnaire.getApplication() + "_Resultados.pdf";
        PDFManipulator.generatePDFResults(questionnaire, calculateResults(questionnaire), path);   
    }
    public void registerAnswer(QuestionnaireModel questionnaire, ArrayList<AnswerItemModel> answers, int id){
        AnswerModel answer = new AnswerModel(answers, id);
        questionnaire.getResults().add(answer);
        for(AnswerModel a : questionnaire.getResults()){
            for(AnswerItemModel b : a.getAnswers()){
                System.out.println(b.getDomainValue());
                System.out.println(b.getMotivationValue());
                System.out.println(b.getSatisfactionValue());
            }
        }
    }
    public static ResearcherModel getInstance(){
        return singleton;
    }
    public QuestionnaireModel createQuestionnaire(String name,String org,String app){
        QuestionnaireModel questionnaire = new QuestionnaireModel(name, org, app);
        this.questionnaires.add(questionnaire);
        return questionnaire;
    }
       public void renameTask(TaskModel task, String name) {
        task.setName(name);
    }

    public void deleteTask(QuestionnaireModel questionnaire, TaskModel task) {
        questionnaire.getTasks().remove(task);
    }
    private int[][][] calculateResults(QuestionnaireModel questionnaire){
        int[][][] results = new int[questionnaire.getTasks().size()][3][3];

        for(AnswerModel answer : questionnaire.getResults()){
            for(AnswerItemModel itemAnswer : answer.getAnswers()){  
                int task = answer.getAnswers().indexOf(itemAnswer);
                int[] dimensionsValues = {
                    itemAnswer.getDomainValue(), 
                    itemAnswer.getMotivationValue(),
                    itemAnswer.getSatisfactionValue()};
                for(int dimension=0; dimension<3; dimension++){
                    if(dimensionsValues[dimension]<5){
                        results[task][dimension][0]++;
                    }else if(dimensionsValues[dimension]==5){
                        results[task][dimension][1]++;
                    }else{
                        results[task][dimension][2]++;
                    }
                }
            }
        }
        return results;
    }
    
    //----------------------------//
    //GET E SETS
    //----------------------------//
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<QuestionnaireModel> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(ArrayList<QuestionnaireModel> questionnaires) {
        this.questionnaires = questionnaires;
    }

 
}
