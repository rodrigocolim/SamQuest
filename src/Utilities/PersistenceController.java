/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Model.Questionnaire.QuestionnaireModel;
import Model.User.ResearcherModel;
import java.util.ArrayList;

/**
 *
 * @author rodri
 */
public class PersistenceController {
    private static PersistenceController singleton = new PersistenceController();
    private final String pathToResearch = "Persistence/User/Research.arq";
 //   private final String pathToQuestionnaires = "Persistence/Questionnaires/";
    private PersistenceController(){
        
    }
    public static PersistenceController getInstance(){
        return singleton;
    }
    public ResearcherModel getResearchFromPresistence(){
        return (ResearcherModel)ObjectManipulator.getInstance().getObjectFromPersistence(pathToResearch);
    }
    public void saveResearchInPersistence(ResearcherModel research){
        ObjectManipulator.getInstance().saveObjectInPersistence(pathToResearch, research);
    }
  /*  public ArrayList<QuestionnaireModel> getQuestionnairesFromPresistence(){
        ArrayList<QuestionnaireModel> questionnaires = new A;
        for(QuestionnaireModel questionnaire : ResearcherModel.getInstance().getQuestionnaires()){
            
        }
        return (ResearcherModel)ObjectManipulator.getInstance().getObjectFromPersistence(pathToResearch);
    }
    public void saveQuestionnaireInPersistence(QuestionnaireModel questionnaire){
        String pathToQuestionnaire = pathToQuestionnaires+questionnaire.getApplication()+".arq";
        ObjectManipulator.getInstance().saveObjectInPersistence(pathToQuestionnaire, questionnaire);
    }*/
}
