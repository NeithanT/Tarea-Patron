/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.subguey;

public abstract class Sandwich implements ISandwich {
    
    protected String tipo; //segun la proteina
    protected int tamano; //15 o 30cem
    protected double precioBase;
    
    //CONSTRUCTOR
    public Sandwich(String tipo, int tamano, double precioBase) {
        this.tipo = tipo;
        this.tamano = tamano;
        this.precioBase = precioBase;
    }
    
    @Override
    public double getPrecio(){
        return precioBase;
    }
    
    @Override
    public String getDescripcion(){
        String descripcion = "Sandwich de" + tipo + " de " + tamano + "cm (" + precioBase + ")";
        return descripcion; 
    }
    
}
