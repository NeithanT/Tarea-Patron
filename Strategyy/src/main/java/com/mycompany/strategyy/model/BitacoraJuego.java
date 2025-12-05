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
public class BitacoraJuego {
    private static BitacoraJuego instancia; // SINGLETON
    private List<String> registros; // Lista de mensajes de la bitácora
    
    private BitacoraJuego() {
        registros = new ArrayList<>();
    }
    
    public static BitacoraJuego getInstancia() {
        if (instancia == null) {
            instancia = new BitacoraJuego();
        }
        return instancia;
    }
    
    public void registrar(String mensaje) {
        registros.add(mensaje);
        // Log + notificar a la UI inmediatamente para evitar retrasos en la vista
        System.out.println("[Bitacora] " + mensaje);
        try {
            com.mycompany.strategyy.controller.ControladorJuego.getInstancia().notificarGolpeAplicado(mensaje);
        } catch (Exception e) {
            // Si el controlador no está listo aún, ignorar (se actualizará cuando se registre)
            System.out.println("[Bitacora] No se pudo notificar a la UI: " + e.getMessage());
        }
    }
    
    public void limpiar() {
        registros.clear();
    }
    
    public List<String> getRegistros() {
        return new ArrayList<>(registros);
    }
    
    public String[] getRegistrosArray() {
        return registros.toArray(new String[0]);
    }
}
