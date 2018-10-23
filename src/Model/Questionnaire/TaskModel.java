/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Questionnaire;

import Model.Builder.DimensionProductModel;
import Model.Builder.DirectorModel;
import Model.Builder.DomainBuilderModel;
import Model.Builder.DimensionBuilderModel;
import Model.Builder.MotivationBuilderModel;
import Model.Builder.SatisfactionBuilderModel;
import java.io.Serializable;

/**
 *
 * @author Sinesyo
 */
public class TaskModel implements Serializable{
    private String name;
    private DimensionProductModel[] dimensions = new DimensionProductModel[3];

    public TaskModel(String nameTask) {
        this.name = nameTask;
        generateDimensions();
    }

    public void generateDimensions(){
        //generating the first item (a) for domain dimension
        //the director has a builder of the type passed
        //so he can call the builder's methods
        //********************************************************************//
        //ITEM A - DOMAIN
        DirectorModel director = new DirectorModel(new DomainBuilderModel());
        director.buildDimension();
        dimensions[0]=director.getDimension();
        //********************************************************************//
        //now, generating for the motivation and satisfaction dimensions
        //********************************************************************//
        //ITEM B - SATISFACTION
        director = new DirectorModel(new SatisfactionBuilderModel());
        director.buildDimension();
        dimensions[1]=director.getDimension();
        //********************************************************************//
        //ITEM C - MOTIVATION
        director = new DirectorModel(new MotivationBuilderModel());
        director.buildDimension();
        dimensions[2]=director.getDimension();
        //********************************************************************//
    }

    public String getName() {
        return name;
    }

    public DimensionProductModel[] getDimensions() {
        return dimensions;
    }
    
}   
