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
public class Boxing implements IArteMarcial {
    private Golpe[] golpes; // Arreglo de golpes disponibles
    private Random random;
    
    public Boxing() {
        random = new Random();
        golpes = new Golpe[3];
        golpes[0] = new Golpe("Jab", random.nextInt(46) + 5);
        golpes[1] = new Golpe("Gancho", random.nextInt(46) + 5, 0, 20);
        golpes[2] = new Golpe("Uppercut", random.nextInt(46) + 5, 11, 8);
    }
    
    @Override
    public String getNombre() {
        return "Boxing";
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

        combo.ejecutar(atacante, defensor); // Ejecutar el combo entre atacante y defensor
    }
}
