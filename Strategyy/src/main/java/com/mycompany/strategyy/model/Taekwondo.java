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
// STRATEGY PATTERN: Concrete Strategy - Una estrategia específica de ataque
// Esta clase implementa una forma particular de atacar (Taekwondo)
public class Taekwondo implements IArteMarcial {
    private Golpe[] golpes;
    private Random random;
    
    public Taekwondo() {
        random = new Random();
        golpes = new Golpe[3];
        golpes[0] = new Golpe("Ap Chagui", random.nextInt(46) + 5); // 5-50
        golpes[1] = new Golpe("Dollyo Chagui", random.nextInt(46) + 5, 0, 10); // +10 daño extra
        golpes[2] = new Golpe("Yeop Chagui", random.nextInt(46) + 5, 15, 0); // +15 vida
    }
    
    @Override
    public String getNombre() {
        return "Taekwondo";
    }
    
    @Override
    public Golpe[] getGolpes() {
        return golpes;
    }
    
    @Override
    public void ejecutarAtaque(Jugador atacante, Jugador defensor) {
        int cantidadGolpes = random.nextInt(4) + 3; // 3-6 golpes
        Combo combo = new Combo(getNombre());
        
        for (int i = 0; i < cantidadGolpes; i++) {
            Golpe golpe = golpes[random.nextInt(golpes.length)];
            combo.agregarGolpe(golpe);
            
            // Aplicar daño
            defensor.recibirDaño(golpe.getDañoTotal());
            
            // Recuperar vida si aplica
            if (golpe.getVidaAdicionalAtacante() > 0) {
                atacante.recuperarVida(golpe.getVidaAdicionalAtacante());
            }
            
            // Registrar en bitácora
            BitacoraJuego.getInstancia().registrar(
                atacante.getNombre() + " usa " + golpe.toString()
            );
        }
    }
}