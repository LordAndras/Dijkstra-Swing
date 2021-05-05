/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.GrafEl;
import utils.EdgeCollector;

public class GrafModel {

    private final int KARAKTER_A = 65;
    private int csucsokSzama;
    private List<Character> nemLatogatott;
    private List<Map> csucsMapList;
    private char start = 'A';

    public GrafModel() {
    }

    public GrafModel(int csucsokSzama) {
        this.csucsokSzama = csucsokSzama;
        this.nemLatogatott = new ArrayList<>();
        csucsMapList = new ArrayList<>();

        for (int i = KARAKTER_A; i < KARAKTER_A + csucsokSzama; i++) {
            nemLatogatott.add((char) i);
        }

        mapInit();
        autoElezo();
    }

    public void nemLatogatottReset() {
        for (int i = KARAKTER_A; i < KARAKTER_A + csucsokSzama; i++) {
            nemLatogatott.add((char) i);
        }
        mapInit();
    }

    private void mapInit() {
        for (int j = 0; j < csucsokSzama; j++) {
            csucsMapList.add(new HashMap<>());
            csucsMapList.get(j).put((char) (KARAKTER_A + j), 0);
        }

    }

    private void autoElezo() {
        for (GrafEl edge : EdgeCollector.getGRAFELEK()) {
            elezo(edge.getElsoNode().getJel()[0], edge.getMasodikNode().getJel()[0], edge.getSulySzam());
        }
    }

    public void elezo(char origo, char b, int i) {

        for (Character ch : nemLatogatott) {

            if (ch == origo) {
                Map<Character, Integer> aktMap = csucsMapList.get((int) ch - KARAKTER_A);
                if (aktMap.get(b) == null) {
                    aktMap.put(b, i);
                }

                Map<Character, Integer> masikCsucsMap = csucsMapList.get((int) b - KARAKTER_A);
                if (masikCsucsMap.get(origo) == null) {
                    masikCsucsMap.put(origo, i);
                }

            }
        }

    }

    public List<Character> getNemLatogatott() {
        return nemLatogatott;
    }

    public List<Map> getCsucsMapList() {
        return csucsMapList;
    }

    public char getStart() {
        return start;
    }

    public void setStart(char start) {
        this.start = start;
    }

    public int getKARAKTER_A() {
        return KARAKTER_A;
    }

    public int getCsucsokSzama() {
        return csucsokSzama;
    }

}
