/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adicionales;

import com.mycompany.subguey.ISandwich;

/**
 *
 * @author Alina
 */
public abstract class AdicionalDecorator implements ISandwich {
    
    protected ISandwich sandwich; //el sandwich a decorar
    protected double precioAdicional;
    protected String nombreAdicional;
    
    //CONSTRUCTOR
    public AdicionalDecorator(ISandwich sandwich, double precioAdicional, String nombreAdicional) {
        this.sandwich = sandwich;
        this.precioAdicional = precioAdicional;
        this.nombreAdicional = nombreAdicional;
    }
    
    @Override
    public double getPrecio() {
        return sandwich.getPrecio() + precioAdicional;
    }

    @Override
    public String getDescripcion() {
        return sandwich.getDescripcion() + " + " + nombreAdicional;
    }
    
}
