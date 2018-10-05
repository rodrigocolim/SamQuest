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
public abstract class ItemBuilderModel {
    protected DimensionProductModel item;
    
   
    /**
     *
     * @return the sam Scale of a dimension
     */
    public abstract byte[] buildScale();
    
    public abstract String buildStatement();
    
    public DimensionProductModel getItem(){
        return this.item;
    }
}
