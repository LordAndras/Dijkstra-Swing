/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import model.Node;
import java.util.ArrayList;

/**
 *
 * @author Andras Sarro <>
 */
public class NodeCollector {

    private static ArrayList<Node> nodes = new ArrayList<>();

    private NodeCollector() {
    }

    public static void addNode(int xCoord, int yCoord, String nodeJele) {
        Node newNode = new Node(xCoord, yCoord, nodeJele);
        nodes.add(newNode);
    }

    public static void setNodes(ArrayList<Node> aNodes) {
        nodes = aNodes;
    }

    public static ArrayList<Node> getNodes() {
        return nodes;
    }
}
