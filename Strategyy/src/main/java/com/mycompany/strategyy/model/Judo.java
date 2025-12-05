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
public class Judo implements IArteMarcial {
    private Golpe[] golpes;
    private Random random;
    
    public Judo() {
        random = new Random();
        golpes = new Golpe[3];
        golpes[0] = new Golpe("Kontsutsuri", random.nextInt(46) + 5);
        golpes[1] = new Golpe("Osotogari", random.nextInt(46) + 5, 0, 18);
        golpes[2] = new Golpe("Uchimata", random.nextInt(46) + 5, 14, 0);
    }
    
    @Override
    public String getNombre() {
        return "Judo";
    }
    
    @Override
    public Golpe[] getGolpes() {
        return golpes;
    }
    
    @Override
    public void ejecutarAtaque(Jugador atacante, Jugador defensor) {
        int cantidadGolpes = random.nextInt(4) + 3;
        Combo combo = new Combo(getNombre());

        for (int i = 0; i < cantidadGolpes; i++) {
            Golpe golpe = golpes[random.nextInt(golpes.length)];
            combo.agregarGolpe(golpe);
        }

        combo.ejecutar(atacante, defensor);
    }
}