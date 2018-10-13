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
    protected DimensionBuilderModel automaker;
    
    public DirectorModel(DimensionBuilderModel automaker){
        this.automaker= automaker;
    }
    
    public void buildDimension(){
        automaker.buildScale();
        automaker.buildStatement();
        
    }
    public DimensionProductModel getDimension(){
        return automaker.getItem();
    }
}
