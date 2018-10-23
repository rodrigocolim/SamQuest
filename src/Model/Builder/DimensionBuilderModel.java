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
public abstract class DimensionBuilderModel {
    protected DimensionProductModel dimension = new DimensionProductModel();
    
   
    /**
     *
     * @return the sam Scale of a dimension
     */
    public abstract void buildScale();
    
    public abstract void buildStatement();
    
    public DimensionProductModel getItem(){
        return this.dimension;
    }
}
