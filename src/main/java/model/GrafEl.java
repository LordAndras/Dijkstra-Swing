/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

/**
 *
 * @author Andras Sarro <>
 */
public class GrafEl implements Serializable {

    private static final long serialVersionUID = 50;
    private final int ATLO_FELE = 10;
    private final int ELTOLAS = 0;
    private Node elsoNode;
    private Node masodikNode;
    private Color color = Color.BLACK;
    private int sulySzam;
    private char[] suly;

    public GrafEl(Node node1, Node node2, int sulySzam) {
        this.elsoNode = node1;
        this.masodikNode = node2;
        this.sulySzam = sulySzam;
        String szam = sulySzam + "";
        suly = new char[szam.length()];
        for (int i = 0; i < szam.length(); i++) {
            suly[i] = szam.charAt(i);
        }

    }

    public void paint(Graphics2D g2d) {
        int x1 = elsoNode.getX();
        int y1 = elsoNode.getY();
        int x2 = masodikNode.getX();
        int y2 = masodikNode.getY();
        Graphics2D vonalzo = (Graphics2D) g2d.create();
        vonalzo.setColor(getColor());
        vonalzo.drawLine(x1 + ATLO_FELE, y1 + ATLO_FELE, x2 + ATLO_FELE, y2 + ATLO_FELE);
        vonalzo.drawChars(suly, 0, suly.length, (x1 + x2) / 2 + ELTOLAS, (y1 + y2) / 2 + ELTOLAS);

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSulySzam() {
        return sulySzam;
    }

    public void setSulySzam(int sulySzam) {
        this.sulySzam = sulySzam;
    }

    public Node getElsoNode() {
        return elsoNode;
    }

    public void setElsoNode(Node elsoNode) {
        this.elsoNode = elsoNode;
    }

    public Node getMasodikNode() {
        return masodikNode;
    }

    public void setMasodikNode(Node masodikNode) {
        this.masodikNode = masodikNode;
    }

}
