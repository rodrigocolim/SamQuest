/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author rodri
 */
public class AddTaskControl {
    private static AddTaskControl singleton = new AddTaskControl(); 
    
    private AddTaskControl(){
        
    }
    public static AddTaskControl getInstance(){
        return singleton;
    }
    public void add(String task){
        //pegarQuestionario e adicionar a string no vetor
        //fechar janela
    }
}
