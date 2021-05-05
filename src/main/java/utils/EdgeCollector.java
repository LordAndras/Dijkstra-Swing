/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.Serializable;
import model.GrafEl;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Node;

/**
 *
 * @author Andras Sarro <>
 */
public class EdgeCollector implements Serializable {

    private static final long serialVersionUID = 5;
    private static ArrayList<GrafEl> GRAFELEK = new ArrayList<>();
    private static Node elsoNode = null;
    private static Node masodikNode = null;

    public static void setGRAFELEK(ArrayList<GrafEl> aGRAFELEK) {
        GRAFELEK = aGRAFELEK;
    }

    private EdgeCollector() {
    }

    public static int createEdge() {
        String grafElSuly = JOptionPane.showInputDialog("Add meg az élsúlyát! Pozitív egész számot írj!");
        try {
            int elSulya = Integer.parseInt(grafElSuly);
            GrafEl ge = new GrafEl(elsoNode, masodikNode, elSulya);

            for (GrafEl grafEl : GRAFELEK) {
                if (grafEl.getElsoNode().equals(elsoNode) && grafEl.getMasodikNode().equals(masodikNode)
                        || grafEl.getElsoNode().equals(masodikNode) && grafEl.getMasodikNode().equals(elsoNode)) {
                    return -1;
                }
            }
            GRAFELEK.add(ge);
            elsoNode = null;
            masodikNode = null;
            return 0;

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Hibás számformátum!" + ex, "Hiba", JOptionPane.WARNING_MESSAGE);
            return -1;
        }

    }

    public static ArrayList<GrafEl> getGRAFELEK() {
        return GRAFELEK;
    }

    public static Node getElsoNode() {
        return elsoNode;
    }

    public static void setElsoNode(Node aElsoNode) {
        elsoNode = aElsoNode;
    }

    public static Node getMasodikNode() {
        return masodikNode;
    }

    public static void setMasodikNode(Node aMasodikNode) {
        masodikNode = aMasodikNode;
    }
}
