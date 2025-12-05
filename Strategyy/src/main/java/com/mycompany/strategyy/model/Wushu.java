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
public class Wushu implements IArteMarcial {
    private Golpe[] golpes;
    private Random random;
    
    public Wushu() {
        random = new Random();
        golpes = new Golpe[3];
        golpes[0] = new Golpe("Chang Quan", random.nextInt(46) + 5);
        golpes[1] = new Golpe("Tan Tui", random.nextInt(46) + 5, 0, 8);
        golpes[2] = new Golpe("Xuanfeng Jiao", random.nextInt(46) + 5, 12, 0);
    }
    
    @Override
    public String getNombre() {
        return "Wushu";
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