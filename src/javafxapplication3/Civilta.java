/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.util.Objects;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

/**
 *
 * @author daryo
 */
public class Civilta {
    private Background c;
    private int pericolo;

    public Civilta(Background c, int pericolo) {
        this.c = c;
        this.pericolo = pericolo;
    }

    public Background getC() {
        return c;
    }

    public int getPericolo() {
        return pericolo;
    }

    @Override
    public String toString() {
        return "Civilta{" + "c=" + c + ", pericolo=" + pericolo + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Civilta other = (Civilta) obj;
        if (this.pericolo != other.pericolo) {
            return false;
        }
        if (!Objects.equals(this.c, other.c)) {
            return false;
        }
        return true;
    }
}
