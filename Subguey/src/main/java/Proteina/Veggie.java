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
public class Veggie extends Sandwich{
    //CONSTRUCTOR
    public Veggie(int tamano) {
        super("Veggie", tamano, calcularPrecio(tamano));
    }

    private static double calcularPrecio(int tamano) {
        switch (tamano) {
            case 15:
                return 8.0;
            case 30:
                return 14.0;
            default: //para tamanos invalidos
                return 8.0;
        }
    }
}
