/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Questionnaire;

import Model.Builder.DimensionProductModel;
import Model.Builder.DirectorModel;
import Model.Builder.DomainBuilderModel;
import Model.Builder.ItemBuilderModel;

/**
 *
 * @author Sinesyo
 */
public class QuestionModel {
    private String task;
    private QuestionnaireModel questionnaire;
    private DimensionProductModel[] items;

    public void generateItems(){
        //generating the first item (a) for domain dimension
        DirectorModel automaker = new DirectorModel(
                new DomainBuilderModel());
        automaker.buildItem();
        items[0]=automaker.getItem();
        //now, it is just to generate for the motivation and satisfaction dimensions
    }
}   
