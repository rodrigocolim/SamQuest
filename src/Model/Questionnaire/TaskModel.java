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
import java.io.Serializable;

/**
 *
 * @author Sinesyo
 */
public class TaskModel implements Serializable{
    private String name;
    private DimensionProductModel[] dimensions;

    public TaskModel(String nameTask) {
        this.name = nameTask;
    }

    public void generateDimensions(){
        //generating the first item (a) for domain dimension
        DirectorModel automaker = new DirectorModel(
                new DomainBuilderModel());
        automaker.buildDimension();
        dimensions[0]=automaker.getDimension();
        //now, it is just to generate for the motivation and satisfaction dimensions
    }

    public String getName() {
        return name;
    }

    public DimensionProductModel[] getDimensions() {
        return dimensions;
    }
    
}   
