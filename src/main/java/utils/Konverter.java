/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import logic.GrafJaro;
import logic.GrafModel;
import model.Node;

/**
 *
 * @author Andras Sarro <>
 */
public class Konverter {

    private GrafModel grafModel;
    private GrafJaro grafJaro;

    public Konverter(Node node) {
        grafModel = new GrafModel(NodeCollector.getNodes().size());
        grafModel.setStart(node.getJel()[0]);
        grafJaro = new GrafJaro(grafModel);
    }
    
    


    public GrafModel getGrafModel() {
        return grafModel;
    }

    public GrafJaro getGrafJaro() {
        return grafJaro;
    }

    public void setGrafModel(GrafModel aGrafModel) {
        grafModel = aGrafModel;
    }

}
