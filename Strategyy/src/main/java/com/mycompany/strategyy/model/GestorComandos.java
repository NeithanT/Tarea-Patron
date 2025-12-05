/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategyy.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker
 * 
 * Componentes del patrón:
 * Command: Interfaz que define el contrato
 * Concrete Command: ComandoAtaque, ComandoReasignarArtes
 * Invoker (Esta clase): Ejecuta los comandos y mantiene historial
 * Receiver: Jugador (que realiza el trabajo)

 * 
 * @author melissa
 */
public class GestorComandos {
    // Historial de todos los comandos ejecutados (solo para auditoría)
    private List<Comando> historialComandos;
    
    public GestorComandos() {
        this.historialComandos = new ArrayList<>();
    }
    
    /**
     * Ejecuta un comando y lo agrega al historial.
     * Nota: mantenemos historial para trazabilidad, pero NO soportamos
     * undo/redo (deshacer/rehacer) para simplificar, tal como solicitaste.
     */
    public void ejecutar(Comando comando) {
        // Ejecutar el comando
        comando.ejecutar();
        // Guardar en historial para audit trail / UI
        historialComandos.add(comando);
    }
    
    /**
     * Obtiene el historial de comandos como strings
     */
    public List<String> obtenerHistorial() {
        List<String> historial = new ArrayList<>();
        for (int i = 0; i < historialComandos.size(); i++) {
            historial.add((i + 1) + ". " + historialComandos.get(i).getDescripcion());
        }
        return historial;
    }
    
    /**
     * Limpia el historial
     */
    public void limpiar() {
        historialComandos.clear();
    }
    
    /**
     * Retorna la cantidad de comandos en el historial
     */
    public int getTamaño() {
        return historialComandos.size();
    }
    
    /**
     * Funciones de undo/redo removidas deliberadamente.
     */
    public boolean puedeDeshacer() { return false; }
    public boolean puedeRehacer() { return false; }
}
