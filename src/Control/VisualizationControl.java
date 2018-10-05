/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import View.VisualizationView;

/**
 *
 * @author rodri
 */
public class VisualizationControl {
    private static VisualizationControl singleton = new VisualizationControl();
    
    private VisualizationControl(){
        
    }
    
    public static VisualizationControl getInstance(){
        return singleton;
    }

    void show() {
        VisualizationView.main(null);
    }
}
