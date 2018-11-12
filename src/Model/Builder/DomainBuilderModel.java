/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Builder;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodri
 */
public class DomainBuilderModel extends DimensionBuilderModel{

    @Override
    public void buildScale() {
        dimension.setScale("Questions/DomainImage.png");
    }

    @Override
    public void buildStatement() {
        dimension.setStatement("Qual o seu nível de sentimento de controle?");
    }
    
}
