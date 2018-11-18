/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Builder;

import java.io.Serializable;


/**
 *
 * @author rodri
 */
public class DimensionProductModel implements Serializable {
    private String statement;
    private String scale;

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }
    
   
}
