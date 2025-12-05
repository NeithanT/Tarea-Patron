/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategyy.model;

import java.util.List;

/**
 *
 * @author melissa
 */
public class ResultadoAtaque {
    private int dañoTotal;
    private int vidaRecuperada;
    private List<String> bitacora;
    
    public ResultadoAtaque(int dañoTotal, int vidaRecuperada, List<String> bitacora) {
        this.dañoTotal = dañoTotal;
        this.vidaRecuperada = vidaRecuperada;
        this.bitacora = bitacora;
    }
    
    public int getDañoTotal() { return dañoTotal; }
    public int getVidaRecuperada() { return vidaRecuperada; }
    public List<String> getBitacora() { return bitacora; }
}