/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategyy.model;

import java.util.Random;

/**
 *
 * @author melissa
 */
public class Golpe {
    private String nombre;
    private int poder; //poder de cada ataque 
    private int vidaAdicionalAtacante; // Vida que recupera quien ataca
    private int dañoAdicionalDefensor; // Daño extra al defensor
    
    public Golpe(String nombre, int poder) {
        this(nombre, poder, 0, 0);
    }
    
    public Golpe(String nombre, int poder, int vidaAdicionalAtacante, int dañoAdicionalDefensor) {
        this.nombre = nombre;
        this.poder = poder;
        this.vidaAdicionalAtacante = vidaAdicionalAtacante;
        this.dañoAdicionalDefensor = dañoAdicionalDefensor;
    }
    public int generarPoderAleatorio() {
        Random random = new Random();
        return random.nextInt(46) + 5; // 5-50
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getPoder() {
        return poder;
    }
    
    public int getVidaAdicionalAtacante() {
        return vidaAdicionalAtacante;
    }
    
    public int getDañoAdicionalDefensor() {
        return dañoAdicionalDefensor;
    }
    
    public int getDañoTotal() {
        return poder + dañoAdicionalDefensor;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(nombre + " [" + poder + " dmg");
        if (vidaAdicionalAtacante > 0) {
            sb.append(", +").append(vidaAdicionalAtacante).append(" vida");
        }
        if (dañoAdicionalDefensor > 0) {
            sb.append(", +").append(dañoAdicionalDefensor).append(" dmg extra");
        }
        sb.append("]");
        return sb.toString();
    }
}
