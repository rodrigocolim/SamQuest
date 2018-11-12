
package Model.Questionnaire;

import java.io.Serializable;
import java.util.ArrayList;


public class QuestionnaireModel implements Serializable{
    private ArrayList<TaskModel> tasks;
    private String application;
    private String projectName;
    private String institution;
    private ArrayList<AnswerModel> results;

    public QuestionnaireModel(String name, String org, String app) {
        this.projectName=name;
        this.institution=org;
        this.application=app;
        this.tasks=new ArrayList<>();
        this.results=new ArrayList<>();
    }
    
    public void generateResults(){
        
    }
    
    public String getProjectName(){
        return this.projectName;
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
}
