/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Questionnaire.QuestionnaireModel;
import View.CreateView;
import View.MainView;
import java.util.ArrayList;

/**
 *
 * @author rodri
 */
public class MainControl {
    private static MainControl singleton = new MainControl();
    
    private MainControl(){
        
    }
    public static MainControl getInstance(){
        return singleton;
    }
    
    public void createQuest() {
        //fechar MainView antes
        //abri prox
        CreateView.main(null);
    }
    public ArrayList<QuestionnaireModel> getQuest(){
        // acessar pasta de questionarios
        //deserialiar cada arquivo na pasta
        //retornar cada questionario
        return null;
    }
    
     static void show() {
        new MainView().setVisible(true);
    }
    
    public void close(MainView aThis) {
        aThis.setVisible(false);
    }
    
    
}
