/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proteina;

import com.mycompany.subguey.Sandwich;

/**
 *
 * @author Alina
 */
public class Pollo extends Sandwich {
    //CONSTRUCTOR
    public Pollo(int tamano) {
        super("Pollo", tamano, calcularPrecio(tamano));
    }

    private static double calcularPrecio(int tamano) {
        switch (tamano) {
            case 15:
                return 12.0;
            case 30:
                return 18.0;
            default: //para tamanos invalidos
                return 12.0;
        }
    }
}
