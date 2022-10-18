/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.finalproject;

/**
 *
 * @author Milan
 */
public class PojisteneOsoby {
    private final String jmeno;
    private final String prijmeni;
    private final int vek;
    private final String telCislo;
    
    public PojisteneOsoby(String jmeno, String prijmeni, int vek, String telCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telCislo = telCislo;
    }
    /**
     * @return the jmeno
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * @return the prijmeni
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * @return the telCislo
     */
    public String getTelCislo() {
        return telCislo;
    }
    
    /**
     * @return the vek
     */
    public int getVek() {
        return vek;
    }

    
      @Override 
    public String toString() {
     return jmeno + "    " + prijmeni + "    " + vek + "    " + telCislo;
    }
}
