/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategyy.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melissa
 */

//Esta clase es el context en el Strategy
//Esta clase es el invitado en el Observer
//esta clase es el receiver en el Command

public class Jugador {
    private String nombre;
    private int vida;
    // S P Context, referencia a la estrategia (arte marcial actual)
    private IArteMarcial arteMarcialActual;
    // S P Lista de estrategias disponibles que el jugador puede usar
    private List<IArteMarcial> artesMarciales;
    private static final int VIDA_MAXIMA = 200;
    
    // OBSERVER P Lista de observadores que se notificarán de cambios
    private List<JuegoObserver> observadores;
    // Combo preparado por la UI (si el jugador generó un combo manualmente)
    private Combo comboPreparado;
    
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.vida = VIDA_MAXIMA;
        this.artesMarciales = new ArrayList<>();
        this.observadores = new ArrayList<>();
        this.comboPreparado = null;
    }
    
    // Observer P Métodos para agregar/remover observadores
    public void agregarObservador(JuegoObserver observer) {
        if (!observadores.contains(observer)) {
            observadores.add(observer);
        }
    }
    
    public void removerObservador(JuegoObserver observer) {
        observadores.remove(observer);
    }
    
    // observer notifica a tds los observadores cuando la vida cambia
    private void notificarVidaCambiada(int vidaAnterior) {
        for (JuegoObserver observer : observadores) {
            observer.onVidaCambiada(this, vidaAnterior, this.vida);
        }
    }
    
    // Strategy permite cambiar la estrategia de ataque (arte marcial)
    public void setArteMarcial(IArteMarcial arteMarcial) {
        this.arteMarcialActual = arteMarcial;
    }

    // Combo preparado usado para que la UI genere un combo y el flujo de ataque
    public void setComboPreparado(Combo combo) {
        this.comboPreparado = combo;
    }

    // Combo preparado que se consume al atacar
    public Combo tomarComboPreparado() {
        Combo c = this.comboPreparado;
        this.comboPreparado = null;
        return c;
    }
    
    // strategy asigna múltiples estrategias disponibles
    public void setArtesMarciales(List<IArteMarcial> artes) {
        this.artesMarciales = artes;
        if (!artes.isEmpty()) {
            this.arteMarcialActual = artes.get(0);
        }
    }
    
    // Strategy delega el ataque a la estrategia actual
    public void atacar(Jugador defensor) {
        if (arteMarcialActual != null) {
            arteMarcialActual.ejecutarAtaque(this, defensor);
        }
    }
    
    // Obverver. Se notifica cuando recibe daño
    public void recibirDaño(int daño) {
        int vidaAnterior = this.vida;
        this.vida -= daño;
        if (this.vida < 0) {
            this.vida = 0;
        }
        // Log para depuración
        System.out.println("[Jugador] " + nombre + " recibió daño: " + daño + " -> vida " + vidaAnterior + "->" + this.vida);
        // Notificar cambio de vida
        notificarVidaCambiada(vidaAnterior);
    }
    
    // Se notifica cuando recupera vida
    public void recuperarVida(int cantidad) {
        int vidaAnterior = this.vida;
        this.vida += cantidad;
        if (this.vida > VIDA_MAXIMA) {
            this.vida = VIDA_MAXIMA;
        }
        // Log para depuración
        System.out.println("[Jugador] " + nombre + " recupera vida: " + cantidad + " -> vida " + vidaAnterior + "->" + this.vida);
        // Notificar cambio de vida
        notificarVidaCambiada(vidaAnterior);
    }
    
    // Permite establecer la vida (necesario para undo/redo)
    public void setVida(int vida) {
        int vidaAnterior = this.vida;
        this.vida = vida;
        if (this.vida < 0) {
            this.vida = 0;
        }
        if (this.vida > VIDA_MAXIMA) {
            this.vida = VIDA_MAXIMA;
        }
        // Log para depuración
        System.out.println("[Jugador] " + nombre + " setVida: " + vida + " -> vida " + vidaAnterior + "->" + this.vida);
        // Notificar cambio de vida
        notificarVidaCambiada(vidaAnterior);
    }
    
    public boolean estaVivo() {
        return vida > 0;
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public IArteMarcial getArteMarcialActual() { return arteMarcialActual; }
    public List<IArteMarcial> getArtesMarciales() { return artesMarciales; }
}
