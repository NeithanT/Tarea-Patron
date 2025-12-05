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
public class KungFu implements IArteMarcial {
    private Golpe[] golpes;
    private Random random;
    
    public KungFu() {
        random = new Random();
        golpes = new Golpe[3];
        golpes[0] = new Golpe("Pei Tsu", random.nextInt(46) + 5);
        golpes[1] = new Golpe("Kuan Tsu", random.nextInt(46) + 5, 0, 7);
        golpes[2] = new Golpe("Long Fist", random.nextInt(46) + 5, 10, 0);
    }
    
    @Override
    public String getNombre() {
        return "Kung Fu";
    }
    
    @Override
    public Golpe[] getGolpes() {
        return golpes;
    }
    
    @Override
    public void ejecutarAtaque(Jugador atacante, Jugador defensor) {
        int cantidadGolpes = random.nextInt(4) + 3;
        
        for (int i = 0; i < cantidadGolpes; i++) {
            Golpe golpe = golpes[random.nextInt(golpes.length)];
            defensor.recibirDaño(golpe.getDañoTotal());
            
            if (golpe.getVidaAdicionalAtacante() > 0) {
                atacante.recuperarVida(golpe.getVidaAdicionalAtacante());
            }
            
            BitacoraJuego.getInstancia().registrar(
                atacante.getNombre() + " usa " + golpe.toString()
            );
        }
    }
}