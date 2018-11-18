/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Initializer;
import Control.MainControl;
import Utilities.ObjectManipulator;
import Model.User.ResearcherModel;
import Utilities.PersistenceController;
import View.MainView;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.SerializationUtils;
/**
 *
 * @author rodri
 */
public class Main {
    
    public static void main(String[] arg) throws IOException{
        MainControl.getInstance().start();
    }
    public static void closePogram(){
        int op;
        op = JOptionPane.showConfirmDialog(null, "Deseja sair?", null, JOptionPane.YES_NO_OPTION);
        if(op == 0 ){
            PersistenceController.getInstance().saveResearchInPersistence(ResearcherModel.getInstance());
            System.exit(0);
        }
    }
  
}
