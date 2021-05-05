/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import model.Node;

/**
 *
 * @author Andras Sarro <>
 */
public class NodeKereso {

    private NodeKereso() {
    }

    public static Node nodeClicked(int xCoord, int yCoord) {
        Node clickedNode = null;
        for (Node node : NodeCollector.getNodes()) {
            if (xCoord < node.getX() + node.getRAD() && xCoord > node.getX()
                    && yCoord < node.getY() + node.getRAD() && yCoord > node.getY()) {
                clickedNode = node;
                break;
            } else {
                clickedNode = null;
            }
        }
        return clickedNode;
    }



}
