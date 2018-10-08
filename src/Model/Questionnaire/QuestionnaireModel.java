
package Model.Questionnaire;

import java.io.Serializable;
import java.util.ArrayList;


public class QuestionnaireModel implements Serializable{
    private ArrayList<QuestionModel> questions;
    private String application;
    private String projectName;
    private String institution;
    private ArrayList<String> tasks;
    private ArrayList<AnswerModel> results;

    public QuestionnaireModel(String name, String org, String app) {
        this.projectName=name;
        this.institution=org;
        this.application=app;
        this.tasks=new ArrayList<>();
    }
    
    public void generateResults(){
        
    }
    
    public String getProjectName(){
        return this.projectName;
    }
    public ArrayList<String> getTasks(){
        return this.tasks;
    }
}
