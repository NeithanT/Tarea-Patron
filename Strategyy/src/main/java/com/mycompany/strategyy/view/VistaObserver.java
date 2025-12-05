/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategyy.view;

import com.mycompany.strategyy.model.Jugador;
import com.mycompany.strategyy.model.JuegoObserver;

/**
 * Implementación del Observer Pattern para la Vista
 * @author melissa
 */
public class VistaObserver implements JuegoObserver {
    
    private JuegoFrame frameParent;
    
    public VistaObserver(JuegoFrame frameParent) {
        this.frameParent = frameParent;
    }
    
    @Override
    public void onVidaCambiada(Jugador jugador, int vidaAnterior, int vidaNueva) {
        // Actualizar la vista cuando cambia la vida
        frameParent.actualizarVista();
        
        System.out.println(" " + jugador.getNombre() + ": " + vidaAnterior + " → " + vidaNueva);
    }
    
    @Override
    public void onGolpeAplicado(String mensaje) {
        // Mostrar el golpe aplicado y actualizar la vista para reflejar la bitácora
        System.out.println("️ " + mensaje);
        // Asegurar actualización de la UI cuando se aplica un golpe
        frameParent.actualizarVista();
    }
    
    @Override
    public void onGanador(Jugador ganador) {
        // Notificar al frame sobre el ganador
        frameParent.mostrarGanador(ganador);
    }
    
    @Override
    public void onJuegoReiniciado() {
        // Reiniciar vistas
        System.out.println("Juego reiniciado");
        frameParent.actualizarVista();
    }
}
