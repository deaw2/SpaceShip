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
public class Posizione {
    private int x;
    private int y;
    private int z;

    public Posizione(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }
    
    public int calcDist(Posizione boh){
        return (int)Math.sqrt(Math.pow(Math.abs((this.x-boh.getX())), 2)+Math.pow(Math.abs((this.y-boh.getY())), 2)+Math.pow(Math.abs((this.z-boh.getZ())), 2));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Posizione other = (Posizione) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        if (this.z != other.z) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Posizione{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}