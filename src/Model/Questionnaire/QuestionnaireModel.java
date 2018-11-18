
package Model.Questionnaire;

import java.io.Serializable;
import java.util.ArrayList;


public class QuestionnaireModel implements Serializable{
    private ArrayList<TaskModel> tasks;
    private String application;
    private ArrayList<AnswerModel> results;

    public QuestionnaireModel(String app) {
        this.application=app;
        this.tasks=new ArrayList<>();
        this.results=new ArrayList<>();
    }
    
    public void generateResults(){
        
    }
    
    public ArrayList<TaskModel> getTasks(){
        return this.tasks;
    }
    public String getApplication(){
        return this.application;
    }
    public ArrayList<AnswerModel> getResults(){
        return results;
    }
    public void setApplication(String name){
        this.application=name;
    }
}
