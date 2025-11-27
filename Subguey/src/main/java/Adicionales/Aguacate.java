/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adicionales;

import com.mycompany.subguey.ISandwich;

public class Aguacate extends AdicionalDecorator {
    
    //CONSTRUCTOR
    public Aguacate(ISandwich sandwich, int tamano) {
        super(sandwich, calcularPrecio(tamano), "aguacate");
    }

    private static double calcularPrecio(int tamano) {
        switch (tamano) {
            case 15:
                return 1.5;
            case 30:
                return 2.5;
            default: //para tamanos invalidos
                return 1.5;
        }
    }
    
}
