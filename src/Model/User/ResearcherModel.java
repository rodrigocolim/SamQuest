
package Model.User;

import Model.Questionnaire.QuestionnaireModel;
import Model.Questionnaire.TaskModel;
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
        
    }
    
    public void editQuestionnaire(){
        
    }
    public void answerQuestionnaire(){
    
    }
    public void deleteQuestionnaire(){
    
    }
    public void addTask(String nameTask, QuestionnaireModel questionnaire){
        questionnaire.getTasks().add(new TaskModel(nameTask));
    } 
    public void organizeTasks(){
        
    }
    public void saveQuestPDF(){
        
    }
    public void saveResultPDF(){
        
    }
    public void registerAnswer(){
        
    }
    public static ResearcherModel getInstance(){
        return singleton;
    }
    public QuestionnaireModel createQuestionnaire(String name,String org,String app){
        QuestionnaireModel questionnaire = new QuestionnaireModel(name, org, app);
        this.questionnaires.add(questionnaire);
        return questionnaire;
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
