/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.strategyy.model;

/**
 * Observer Pattern - Interfaz para observar cambios en el juego
 * @author melissa
 */
public interface JuegoObserver {
    
    /**
     * Se llamará cuando la vida de un jugador cambia
     */
    void onVidaCambiada(Jugador jugador, int vidaAnterior, int vidaNueva);
    
    /**
     * Se llamará cuando se aplica un golpe
     */
    void onGolpeAplicado(String mensaje);
    
    /**
     * Se llamará cuando hay un ganador
     */
    void onGanador(Jugador ganador);
    
    /**
     * Se llamará cuando el juego se reinicia
     */
    void onJuegoReiniciado();
}
