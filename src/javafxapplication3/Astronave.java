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
public class Astronave {
    private Posizione pos;
    private int scudi;
    private int sensori;
    private int cap;
    private int comF=0;

    public Astronave(Posizione pos, int scudi, int sensori, int cap) {
        this.pos = pos;
        this.scudi = scudi;
        this.sensori = sensori;
        this.cap = cap;
    }
    //movimento
    public void su(int n){
        pos.setX(pos.getX()+n);
    }
    public void giu(int n){
        pos.setX(pos.getX()-n);
    }
    public void destra(int n){
        pos.setY(pos.getY()+n);
    }
    public void sinistra(int n){
        pos.setY(pos.getY()-n);
    }
    public void avanti(int n){
        pos.setZ(pos.getZ()+n);
    }
    public void dietro(int n){
        pos.setZ(pos.getZ()-n);
    }
    

    public Posizione getPos() {
        return pos;
    }

    public int getScudi() {
        return scudi;
    }

    public int getSensori() {
        return sensori;
    }

    public int getCap() {
        return cap;
    }
    
    public int getComF() {
        return comF;
    }

    public void setPos(Posizione pos) {
        this.pos = pos;
    }

    public void setScudi(int scudi) {
        this.scudi = scudi;
    }

    public void setSensori(int sensori) {
        this.sensori = sensori;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }
    
    public void setComF(int comF) {
        this.comF = comF;
    }
    
    public void incComF(){
        this.comF = this.comF + 1;
    }

    @Override
    public String toString() {
        return "Astronave{" + "posizione=" + pos.toString() + ", scudi=" + scudi + ", sensori=" + sensori + ", cap. Commerciale=" + cap + ", Commerci Fatti=" + comF +'}';
    }
}