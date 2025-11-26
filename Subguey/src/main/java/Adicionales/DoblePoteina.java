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
public class DoblePoteina extends AdicionalDecorator{
    //CONSTRUCTOR
    public DoblePoteina(ISandwich sandwich, int tamano) {
        super(sandwich, calcularPrecio(tamano), "doble proteina");
    }

    private static double calcularPrecio(int tamano) {
        switch (tamano) {
            case 15:
                return 4.5;
            case 30:
                return 8.;
            default: //para tamanos invalidos
                return 4.5;
        }
    }
}
