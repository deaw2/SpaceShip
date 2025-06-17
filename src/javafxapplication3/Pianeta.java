/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

/**
 *
 * @author daryo
 */
public class Pianeta {
    private Posizione pos;
    private int tCiv;
    private boolean found = false;

    public Pianeta(Posizione pos, int tCiv) {
        this.pos = pos;
        this.tCiv = tCiv;
    }

    public Posizione getPos() {
        return pos;
    }

    public boolean isFound() {
        return found;
    }
    
    public int getCiv() {
        return tCiv;
    }
    
    public boolean getFound() {
        return found;
    }

    public void setPos(Posizione pos) {
        this.pos = pos;
    }

    public void settCiv(int tCiv) {
        this.tCiv = tCiv;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    @Override
    public String toString() {
        return "Pianeta{" + "pos=" + pos.toString() + ", tCiv=" + tCiv + ", found=" + found + '}';
    }
}
