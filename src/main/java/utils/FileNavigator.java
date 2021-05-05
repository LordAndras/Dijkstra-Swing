/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import model.GrafEl;
import model.Node;

/**
 *
 * @author Andras Sarro <>
 */
public final class FileNavigator extends JFrame {

    public FileNavigator(int option) {
        this.setTitle("Mentés");
        this.setSize(500, 400);
        this.setLocationRelativeTo(this);
        UIManager.put("FileChooser.saveButtonText", "Mentés");
        UIManager.put("FileChooser.openButtonText", "Megnyitás");
        UIManager.put("FileChooser.cancelButtonText", "Mégsem");
        JFileChooser fc = new JFileChooser("c:/prog");
        if (option == 1) {
            int megerosites = fc.showSaveDialog(this);
            if (megerosites == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fc.getSelectedFile();
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileToSave))) {
                    oos.writeObject(EdgeCollector.getGRAFELEK());
                    System.out.println("A mentés sikeres! Fájl neve: " + fileToSave.getAbsolutePath());
                } catch (FileNotFoundException ex) {
                    System.out.println("Nem található ilyen file! " + ex);
                } catch (IOException ex) {
                    System.out.println("File írási hiba! " + ex);
                }
            }
        } else {
            int betoltes = fc.showOpenDialog(this);
            if (betoltes == JFileChooser.APPROVE_OPTION) {
                File fileToOpen = fc.getSelectedFile();
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileToOpen))) {
                    ArrayList<GrafEl> loadedEdges =  (ArrayList<GrafEl>) ois.readObject();
                    EdgeCollector.setGRAFELEK(loadedEdges);
                    Set<Node> loadedNodes = new HashSet<>();
                    for (GrafEl ge  : loadedEdges) {
                        loadedNodes.add(ge.getElsoNode());
                        loadedNodes.add(ge.getMasodikNode());
                    }
                    ArrayList<Node> nodeList = new ArrayList<>();
                    for (Node node : loadedNodes) {
                        nodeList.add(node);
                    }
                    nodeList.sort(new NodeSorter());
                    NodeCollector.setNodes(nodeList);
                    System.out.println("A betöltést sikerült!");
                } catch (FileNotFoundException ex) {
                    System.out.println("Nem található ilyen file! " + ex);
                } catch (IOException ex) {
                    System.out.println("File olvasási hiba! " + ex);
                } catch (ClassNotFoundException ex) {
                    System.out.println("A gráf nem gráf! " + ex);
                }
            }
        }

    }

}
