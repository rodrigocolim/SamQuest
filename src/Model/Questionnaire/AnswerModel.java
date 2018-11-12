/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Questionnaire;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Sinesyo
 */
public class AnswerModel implements Serializable{
    private final int idParticipant;
    private final ArrayList<AnswerItemModel> items;
    
    public AnswerModel(ArrayList<AnswerItemModel> answers, int id){
        this.items=answers;
        this.idParticipant=id;
    }
    public ArrayList<AnswerItemModel> getAnswers(){
        return items;
    }
    public int getIdParticipant(){
        return this.idParticipant;
    }
}
