/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dijkstraswing.MainFrame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author Andras Sarro <>
 */
public class MyOutputStream extends Thread {

    private BufferedReader reader;
    private JTextArea textArea;

    public MyOutputStream(JTextArea textArea) {
        this.textArea = textArea;
        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        PipedOutputStream pOS = new PipedOutputStream();
        System.setOut(new PrintStream(pOS));
        PipedInputStream pIS;
        try {
            pIS = new PipedInputStream(pOS);
            reader = new BufferedReader(new InputStreamReader(pIS));
        } catch (IOException ex) {
            System.out.println(MainFrame.class.getName() + " " + ex);
        }
    }

    public void clear() {
        textArea.setText("");
    }

    @Override
    public void run() {
        int rowsToGo = textArea.getRows();
        StringBuilder sb = new StringBuilder();
        int rowsAdded = 0;
        while (true) {
            try {
                String line = reader.readLine();
                if (rowsToGo <= NodeCollector.getNodes().size() && line != null) {
                    sb.append(line).append("\n");
                    rowsAdded++;
                    if (rowsAdded == NodeCollector.getNodes().size()) {
                        clear();
                        rowsAdded = 0;
                        textArea.append(sb.toString());
                        sb.delete(0, sb.length());
                        rowsToGo = textArea.getRows();
                    }
                } else if (line != null) {
                    textArea.append(line + "\n");
                    rowsToGo--;
                }

            } catch (IOException ex) {
                System.out.println(MainFrame.class.getName() + " " + ex);

            }
        }
    }

}
