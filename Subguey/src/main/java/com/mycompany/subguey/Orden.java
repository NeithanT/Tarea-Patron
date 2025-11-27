/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.subguey;

import java.util.ArrayList;

public class Orden {
    
    private ArrayList<ISandwich> sandwiches; //por si pide varios sandwiches
    
    //CONSTRUCTOR
    public Orden() {
        sandwiches = new ArrayList<>();
    }
    
    public void agregarSandwich(ISandwich sandwich){
        sandwiches.add(sandwich);
    }
    
    public double getPrecioTotal(){
        double total = 0;
        for (ISandwich sandwich : sandwiches){
            total += sandwich.getPrecio();
        } 
        return total;
    }
    
    public String getDescripcionOrden(){
        StringBuilder descripcion = new StringBuilder();
        
        //descipcio y precio de cada uno de los sandwiches
        for (ISandwich sandwich : sandwiches){
            descripcion.append(sandwich.getDescripcion())
                    .append(" - Precio: $")
                    .append(sandwich.getPrecio())
                    .append("\n");
        }
        
        descripcion.append("-------------------------------------------------\n");
        descripcion.append("Total $").append(getPrecioTotal());
        return descripcion.toString(); //para convertir a string
    }
    
    public void limpiarOrden(){
        sandwiches.clear();
    }
    
}
