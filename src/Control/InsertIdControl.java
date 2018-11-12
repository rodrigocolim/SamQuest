/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import View.InsertIdView;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class InsertIdControl {
    private static final InsertIdControl singleton = new InsertIdControl();
    
    private InsertIdControl(){
        
    }
    
    public static InsertIdControl getInstance(){
        return singleton;
    } 
    
    public void showView(){
        InsertIdView.main(null);
    }
    public void advanceToNextView(int id){
        if(idValid(id))
            ResponseControl.getInstance().start(id);
        else{
            JOptionPane.showMessageDialog(null, "Identificador de Usuário já existe!");
            showView();
        }
    }
    private boolean idValid(int id) {
        return !ResponseControl.getInstance().theresId(id);
    }
}
