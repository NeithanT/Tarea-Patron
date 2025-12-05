/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategyy.controller;

import com.mycompany.strategyy.model.Jugador;
import com.mycompany.strategyy.model.IArteMarcial;
import com.mycompany.strategyy.model.BitacoraJuego;
import com.mycompany.strategyy.model.ArteMarcialFactory;
import com.mycompany.strategyy.model.Combo;
import com.mycompany.strategyy.model.Golpe;
import com.mycompany.strategyy.model.JuegoObserver;
import com.mycompany.strategyy.model.Comando;
import com.mycompany.strategyy.model.ComandoAtaque;
import com.mycompany.strategyy.model.ComandoReasignarArtes;
import com.mycompany.strategyy.model.GestorComandos;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author melissa
 */
// CONTROLADOR (SINGLETON)

// Esta clase es el cerebro del juego. Centraliza la lógica de turns,
// la creación/reasignación de artes marciales y la coordinación entre
// el modelo (Jugadores) y la vista. 
// Está implementada como Singleton para que exista una única instancia
// durante la ejecución del programa.

public class ControladorJuego {
    // sngt instancia única
    private static ControladorJuego instancia;

    // Jugadores participantes
    private Jugador jugador1;
    private Jugador jugador2;

    private Random random;

    // Lista breve de nombres de artes usadas por J2 en el último ataque
    // (se utiliza para mostrar imágenes/indicadores en la UI)
    private List<String> artesUsadasJ2;
    
    // Aquí registramos cada acción importante
    private GestorComandos gestorComandos;
    
    // PAra cuando cambie el estado relevante (vida, ganador, etc.) notificamos
    private List<JuegoObserver> observadores;
    
    // Constructor privado (parte del patrón Singleton)
    private ControladorJuego() {
        random = new Random();
        artesUsadasJ2 = new ArrayList<>();
        gestorComandos = new GestorComandos();
        observadores = new ArrayList<>();
    }

    // Marca de tiempo (ms) de la última inicialización/reinicio del juego.
    // Se usa para detectar si durante la ejecución de un combo se reinició
    private long ultimaInicializacionMillis = 0;
    
    public static ControladorJuego getInstancia() {
        if (instancia == null) {
            instancia = new ControladorJuego();
        }
        return instancia;
    }
    
    // para agregar observadores
    public void agregarObservador(JuegoObserver observer) {
        if (!observadores.contains(observer)) {
            observadores.add(observer);
        }
        // También agregar a los jugadores
        if (jugador1 != null) jugador1.agregarObservador(observer);
        if (jugador2 != null) jugador2.agregarObservador(observer);
    }

    //para remover observadores
    public void removerObservador(JuegoObserver observer) {
        observadores.remove(observer);
        if (jugador1 != null) jugador1.removerObservador(observer);
        if (jugador2 != null) jugador2.removerObservador(observer);
    }
    
    public void notificarGanador(Jugador ganador) {
        for (JuegoObserver observer : observadores) {
            observer.onGanador(ganador);
        }
    }
    
    private void notificarJuegoReiniciado() {
        for (JuegoObserver observer : observadores) {
            observer.onJuegoReiniciado();
        }
    }
    // inicializarJuego prepara todo para comenzar una nueva partida
    public void inicializarJuego() {
        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");
        
        jugador1.setArtesMarciales(ArteMarcialFactory.asignarArtesAleatorias());
        jugador2.setArtesMarciales(ArteMarcialFactory.asignarArtesAleatorias());
        
        BitacoraJuego.getInstancia().limpiar();
        gestorComandos.limpiar();
        // Asegurar que las artes usadas por J2 se reinician entre partidas
        artesUsadasJ2.clear();
        
        // Agregar observadores a los jugadores
        for (JuegoObserver observer : observadores) {
            jugador1.agregarObservador(observer);
            jugador2.agregarObservador(observer);
        }
        
        notificarJuegoReiniciado();
        // Registrar la marca de tiempo al final de la inicialización
        ultimaInicializacionMillis = System.currentTimeMillis();
    }

    // Devuelve la marca de tiempo (ms) de la última inicialización del juego
    public long getUltimaInicializacionMillis() {
        return ultimaInicializacionMillis;
    }

    /**
     * Notifica a los observadores que se aplicó un golpe (mensaje de bitácora).
     */
    public void notificarGolpeAplicado(String mensaje) {
        for (JuegoObserver observer : observadores) {
            observer.onGolpeAplicado(mensaje);
        }
    }
    
    
    public void reasignarArtes(Jugador jugador) {
        //  Usar comando para reasignar
        Comando comando = new ComandoReasignarArtes(jugador);
        gestorComandos.ejecutar(comando);
    }

    // cuando el usuario pulsa "Reasignar", queremos que la acción
    // quede registrada para poder deshacerla si es necesario. Por eso usamos un
    // comando en lugar de cambiar las artes directamente.
    
    public void jugador1Ataca() {
        // Encapsular el ataque como comando
        Comando comando = new ComandoAtaque(jugador1, jugador2);
        gestorComandos.ejecutar(comando);
        
        // Verificar si hay ganador
        if (!jugador2.estaVivo()) {
            notificarGanador(jugador1);
        }
    }

    // Encapsulamos el ataque de J1 en un comando 
    
    public void jugador2AtacaAleatorio() {
        artesUsadasJ2.clear();
        int cantidadGolpes = random.nextInt(4) + 3;
        List<IArteMarcial> artes = jugador2.getArtesMarciales();

        // Construir un combo con golpes seleccionados de las artes aleatorias
        Combo combo = new Combo("J2 Random Combo");

        for (int i = 0; i < cantidadGolpes; i++) {
            IArteMarcial arteAleatoria = artes.get(random.nextInt(artes.size()));
            String nombreArte = arteAleatoria.getNombre();

            if (!artesUsadasJ2.contains(nombreArte)) {
                artesUsadasJ2.add(nombreArte);
            }

            Golpe[] golpes = arteAleatoria.getGolpes();
            Golpe golpe = golpes[random.nextInt(golpes.length)];
            combo.agregarGolpe(golpe);
        }

        // Ejecutar el combo como J2 atacando a J1 (Combo usa el poder fijo de cada Golpe)
        combo.ejecutar(jugador2, jugador1);

        if (!jugador1.estaVivo()) {
            notificarGanador(jugador2);
        }
    }
    
    public List<String> getArtesUsadasJ2() {
        return new ArrayList<>(artesUsadasJ2);
    }
    
    public boolean hayGanador() {
        return !jugador1.estaVivo() || !jugador2.estaVivo();
    }
    
    public Jugador getGanador() {
        if (!jugador1.estaVivo()) return jugador2;
        if (!jugador2.estaVivo()) return jugador1;
        return null;
    }
    
    // Command Pattern 
    public List<String> obtenerHistorialComandos() {
        return gestorComandos.obtenerHistorial();
    }
    
    public boolean puedeDeshacer() {
        return gestorComandos.puedeDeshacer();
    }
    
    public boolean puedeRehacer() {
        return gestorComandos.puedeRehacer();
    }
    
    public Jugador getJugador1() { return jugador1; }
    public Jugador getJugador2() { return jugador2; }
}