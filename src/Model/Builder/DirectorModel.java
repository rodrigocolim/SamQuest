/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Builder;

/**
 *
 * @author rodri
 */
public class DirectorModel {
    protected DimensionBuilderModel builder;
    
    public DirectorModel(DimensionBuilderModel builder){
        this.builder= builder;
    }
    
    public void buildDimension(){
        builder.buildScale();
        builder.buildStatement();
        
    }
    public DimensionProductModel getDimension(){
        return builder.getItem();
    }
}
