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
    protected ItemBuilderModel automaker;
    
    public DirectorModel(ItemBuilderModel automaker){
        this.automaker= automaker;
    }
    
    public void buildItem(){
        automaker.buildScale();
        automaker.buildStatement();
        
    }
    public DimensionProductModel getItem(){
        return automaker.getItem();
    }
}
