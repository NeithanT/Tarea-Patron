/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategyy.model;

import java.util.List;

/**
 * Implementación concreta del comando de reasignación
 *
 * Este comando encapsula la reasignación de artes marciales de un jugador
 *
 *
 * @author melissa
 */
public class ComandoReasignarArtes implements Comando {
    private Jugador jugador;
    private List<IArteMarcial> artesAnteriores;
    private List<IArteMarcial> artesNuevas;

    public ComandoReasignarArtes(Jugador jugador) {
        this.jugador = jugador;
        // Guardar las artes actuales antes de reasignar (audit trail)
        this.artesAnteriores = new java.util.ArrayList<>(jugador.getArtesMarciales());
    }

    // Ejecuta la reasignación
    @Override
    public void ejecutar() {
        artesNuevas = ArteMarcialFactory.asignarArtesAleatorias();
        jugador.setArtesMarciales(artesNuevas);
    }

    @Override
    public String getDescripcion() {
        return jugador.getNombre() + " reasignó sus artes marciales";
    }
}
