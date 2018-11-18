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
