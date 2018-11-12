/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Questionnaire;

/**
 *
 * @author rodri
 */
public class AnswerItemModel {
    String taskName;
    int domainValue;
    int motivationValue;
    int satisfactionValue;
    
    public AnswerItemModel(String name, int dV, int mV, int sV){
        this.taskName=name;
        this.domainValue=dV;
        this.motivationValue=mV;
        this.satisfactionValue=sV;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getDomainValue() {
        return domainValue;
    }

    public int getMotivationValue() {
        return motivationValue;
    }

    public int getSatisfactionValue() {
        return satisfactionValue;
    }
    
}
