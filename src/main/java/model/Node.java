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
public class Node implements Serializable {

    private static final long serialVersionUID = 51;
    private int x, y;
    private final int RAD = 15;
    private Color color = Color.BLACK;
    private char[] jel;


    public Node() {

    }

    public Node(int x, int y, String s) {
        this.x = x;
        this.y = y;
        jel = new char[1];
        jel[0] = s.charAt(0);

    }

    public void paint(Graphics2D g2d) {
        Graphics2D nodeGraphic2D = (Graphics2D) g2d.create();
        nodeGraphic2D.setColor(getColor());
        nodeGraphic2D.fillOval(x, y, RAD, RAD);
        nodeGraphic2D.drawChars(jel, 0, 1, x, y);
        
    }

    @Override
    public String toString() {
        return "Node '" + jel[0] + "', x: " + x + ", y: " + y;
    }

    
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRAD() {
        return RAD;
    }

    public char[] getJel() {
        return jel;
    }

    
}
