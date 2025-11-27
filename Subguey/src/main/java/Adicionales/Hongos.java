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
public class Hongos extends AdicionalDecorator{
    //CONSTRUCTOR
    public Hongos(ISandwich sandwich, int tamano) {
        super(sandwich, calcularPrecio(tamano), "hongos");
    }

    private static double calcularPrecio(int tamano) {
        switch (tamano) {
            case 15:
                return 0.8;
            case 30:
                return 1.45;
            default: //para tamanos invalidos
                return 0.8;
        }
    }
}
