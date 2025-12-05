/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.strategyy.model;

/**
 *  Interfaz que define el contrato para todas las estrategias de ataque
 * 
 * Componentes del patrón:
 *  Strategy Define la familia de algoritmos
 *  Concrete Strategies: Taekwondo, Wushu, Sumo, etc
 *  Context: Jugador (que usa la estrategia)
 * 
 * @author melissa
 */
public interface IArteMarcial {
    
    //  Cada arte marcial tiene un nombre único
    String getNombre();
    
    //  Cada arte marcial tiene 3 golpes específicos
    Golpe[] getGolpes();
    
    // cada arte marcial ataca de forma diferente
    void ejecutarAtaque(Jugador atacante, Jugador defensor);
}
