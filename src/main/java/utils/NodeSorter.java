/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Comparator;
import model.Node;

/**
 *
 * @author Andras Sarro <>
 */
public class NodeSorter implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        if (o1.getJel()[0] < o2.getJel()[0]) {
            return 1;
        } else {
            return -1;
        }
    }

 
    
}
