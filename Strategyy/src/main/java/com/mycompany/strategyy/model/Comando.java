/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.strategyy.model;

/**
 * Interfaz para encapsular acciones del juego
 * @author melissa
 */
public interface Comando {
    
    /**
     * Ejecuta el comando
     */
    void ejecutar();
    
    /**
     * Obtiene una descripción del comando para el historial
     */
    String getDescripcion();
}
