/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Initializer;
import Utilities.ObjectManipulator;
import Model.User.ResearcherModel;
import View.MainView;
import java.io.IOException;
import org.apache.commons.lang3.SerializationUtils;
/**
 *
 * @author rodri
 */
public class Main {
    private static ResearcherModel user;
    
    public static void main(String[] arg) throws IOException{
        ObjectManipulator objectManipulator = ObjectManipulator.getObjectManipulator();
        
        ResearcherModel a = ResearcherModel.getInstance();
        a.setName("0i");
        objectManipulator.saveObject("User/user.arq", SerializationUtils.serialize(a));
        byte[] fileUser = objectManipulator.getObject("User/user.arq");
        user = (ResearcherModel) SerializationUtils.deserialize(fileUser);
        System.out.println(user.getName()+" "+user.getEmail());
        MainView.main(null);
    }
    public static ResearcherModel getUser(){
        return user;
    }
}
