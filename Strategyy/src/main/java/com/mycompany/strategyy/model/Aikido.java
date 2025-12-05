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
public class Aikido implements IArteMarcial {
    private Golpe[] golpes; // Arreglo de golpes disponibles en Aikido
    private Random random;
    
    public Aikido() {
        random = new Random();
        golpes = new Golpe[3];
        golpes[0] = new Golpe("Ikkyo", random.nextInt(46) + 5, 25, 0);
        golpes[1] = new Golpe("Nikkyo", random.nextInt(46) + 5, 20, 0);
        golpes[2] = new Golpe("Kote Gaeshi", random.nextInt(46) + 5, 0, 6);
    }
    
    @Override
    public String getNombre() {
        return "Aikido";
    }
    
    @Override
    public Golpe[] getGolpes() {
        return golpes;
    }
    
    @Override
    public void ejecutarAtaque(Jugador atacante, Jugador defensor) {
        int cantidadGolpes = random.nextInt(4) + 3;   // Entre 3 y 6 golpes
        Combo combo = new Combo(getNombre());  // Crear un nuevo combo para Aikido

        for (int i = 0; i < cantidadGolpes; i++) {
            Golpe golpe = golpes[random.nextInt(golpes.length)]; 
            combo.agregarGolpe(golpe);
        }

        combo.ejecutar(atacante, defensor); // Ejecutar el combo entre atacante y defensor
    }
}
