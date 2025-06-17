/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.util.ArrayList;

/**
 *
 * @author daryo
 */

public class finestra{
    static Astronave temp;
    static ArrayList<Pianeta> temp2;
    static int lvlPericolo = -1;

    public static Astronave getAstronave(){
        return temp;
    }
    public static ArrayList<Pianeta> getPianeti(){
        return temp2;
    }
    public static int getLvlPericolo() {
        return lvlPericolo;
    }

    public static void setAstronave(Astronave temp) {
        finestra.temp = temp;
    }
    public static void setPianeti(ArrayList<Pianeta> temp2) {
        finestra.temp2 = temp2;
    }
    public static void setLvlPericolo(int lvlPericolo) {
        finestra.lvlPericolo = lvlPericolo;
    }

}