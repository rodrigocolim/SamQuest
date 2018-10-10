/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Initializer;
import Utilities.Manipulator;
import Model.User.ResearcherModel;
import View.MainView;
import java.io.IOException;
import static java.lang.System.exit;
/**
 *
 * @author rodri
 */
public class Main {
    private static ResearcherModel user;
    
    public static void main(String[] arg) throws IOException{
        Manipulator objectManipulator = Manipulator.getObjectManipulator();
        
        ResearcherModel a = ResearcherModel.getInstance();
        a.setName("Steeve");
        a.setEmail("steeve.ohEsteeve@gmail.com");
        a.setPassword("jeangrey");
        objectManipulator.saveObject("User/", objectManipulator.serialize(a));
        //buscar o usuarios nos arquivos
      exit(0)  ;
        byte[] fileUser = objectManipulator.getObject("User/user.");
        user = (ResearcherModel) objectManipulator.deserialize(fileUser);
        MainView.main(null);
    }
    public static ResearcherModel getUser(){
        return user;
    }
}
