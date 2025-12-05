/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategyy.model;

/**
 * Implementación concreta del comando de ataque
 * 
 * Componentes del patrón:
 * Ya tenemos la clase comando, que es la que define 
 * Esta clase es la implementación concreta del comando 
 * Este comando encapsula un ataque entre dos jugadores, guardando:

 * @author melissa
 */
public class ComandoAtaque implements Comando {
    // El objeto que recibe la acción (Receiver)
    private Jugador atacante;
    private Jugador defensor;
    
    // Estado guardado para historial
    private int vidaDefensorAntes;
    private int vidaAtacanteAntes;
    private String descripcion;
    
    public ComandoAtaque(Jugador atacante, Jugador defensor) {
        this.atacante = atacante;
        this.defensor = defensor;
        this.vidaDefensorAntes = defensor.getVida();
        this.vidaAtacanteAntes = atacante.getVida();
        this.descripcion = atacante.getNombre() + " ataca a " + defensor.getNombre();
    }
    
    // Se ejecuta la acción
    @Override
    public void ejecutar() {
        // Guardar vidas antes del ataque
        vidaDefensorAntes = defensor.getVida();
        vidaAtacanteAntes = atacante.getVida();
        
        // si el atacante tiene un combo preparado, usarlo;
        // y si no, hacer un ataque normal
        Combo preparado = atacante.tomarComboPreparado();
        if (preparado != null) {
            preparado.ejecutar(atacante, defensor);
        } else {
            atacante.atacar(defensor);
        }
    }
    
    @Override
    public String getDescripcion() {
        return descripcion;
    }
}
