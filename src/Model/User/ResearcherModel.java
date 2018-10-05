
package Model.User;

import Model.Questionnaire.QuestionnaireModel;
import java.util.ArrayList;

public class ResearcherModel {
    private String name;
    private String email;
    private String password;
    private ArrayList<QuestionnaireModel> questionnaires;
    private static ResearcherModel singleton;
    
    private ResearcherModel(){
        
    }
    
    public void editQuestionnaire(){
        
    }
    public void answerQuestionnaire(){
    
    }
    public void deleteQuestionnaire(){
    
    }
    public void createQuestionnaire(QuestionnaireModel prototype){
        
    }
    public void addFunctionality(){
        
    } 
    public void organizeFunctionality(){
        
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
    public QuestionnaireModel createPrototype(String name,String org,String app){
        return new QuestionnaireModel(name,org,app);
    }
}
