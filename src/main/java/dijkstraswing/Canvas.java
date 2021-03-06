/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraswing;

import model.GrafEl;
import model.Node;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import utils.EdgeCollector;
import utils.Konverter;
import utils.NodeCollector;
import utils.NodeKereso;

/**
 *
 * @author Andras Sarro <>
 */
public final class Canvas extends JPanel {

    private int index = 0;
    private boolean NodeAddButtonActive;
    private boolean elso = true;
    private boolean start = false;
    private final int ATLO_FELE = 10;
    private final int KARAKTER_A = 65;
    private Konverter konverter = null;

    public Canvas() {
        initComponents();
        this.setSize(700, 600);
        NodeAddButtonActive = false;

        addMouseListener(new MouseAdapter() {

            boolean nodeClicked = false;
            Node kattintottNode = new Node();

            @Override
            public void mousePressed(MouseEvent e) {

                int x = e.getX();
                int y = e.getY();

                nodeClicked = (kattintottNode = NodeKereso.nodeClicked(x, y)) != null;
                if (start) {
                    if (nodeClicked) {
                        konverter = new Konverter(kattintottNode);
                        konverter.getGrafJaro().jardBe();
                    }
                } else {
                    if (!NodeAddButtonActive) {
                        if (!nodeClicked) {
                            String jel = (char) (KARAKTER_A + getIndex()) + "";
                            index++;
                            NodeCollector.addNode(e.getX() - ATLO_FELE, e.getY() - ATLO_FELE, jel);
                            repaint();
                        }
                    } else {
                        if (isElso() && nodeClicked) {
                            EdgeCollector.setElsoNode(kattintottNode);
                            setElso(false);
                            nodeClicked = false;
                        } else if (!isElso() && nodeClicked && !EdgeCollector.getElsoNode().equals(kattintottNode)) {
                            EdgeCollector.setMasodikNode(kattintottNode);
                            setElso(true);
                            nodeClicked = false;
                            elezo();
                            repaint();
                        }
                    }
                }
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

        Graphics2D rajzLap = (Graphics2D) g.create();
        for (Node node : NodeCollector.getNodes()) {
            node.paint(rajzLap);
        }

        for (GrafEl grafEl : EdgeCollector.getGRAFELEK()) {
            grafEl.paint(rajzLap);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void elezo() {
        int hiba = EdgeCollector.createEdge();
        if (hiba == -1) {
            JOptionPane.showMessageDialog(this, "Van m??r ??l!", "Hiba", JOptionPane.WARNING_MESSAGE);
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setNodeAddButtonActive(boolean NodeAddButtonActive) {
        this.NodeAddButtonActive = NodeAddButtonActive;
    }

    public boolean isElso() {
        return elso;
    }

    public void setElso(boolean elso) {
        this.elso = elso;
    }

    public void setStart(boolean start) {
        this.start = start;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
