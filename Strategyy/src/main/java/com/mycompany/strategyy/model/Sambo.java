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
public class Sambo implements IArteMarcial {
    private Golpe[] golpes;
    private Random random;
    
    public Sambo() {
        random = new Random();
        golpes = new Golpe[3];
        golpes[0] = new Golpe("Breast Hook", random.nextInt(46) + 5, 0, 9);
        golpes[1] = new Golpe("Uppercut", random.nextInt(46) + 5);
        golpes[2] = new Golpe("Flying Mare", random.nextInt(46) + 5, 16, 0);
    }
    
    @Override
    public String getNombre() {
        return "Sambo";
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
