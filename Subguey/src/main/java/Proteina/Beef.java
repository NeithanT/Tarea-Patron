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
public class Beef extends Sandwich{
    
    //CONSTRUCTOR
    public Beef(int tamano) {
        super("Beef", tamano, calcularPrecio(tamano));
    }

    private static double calcularPrecio(int tamano) {
        switch (tamano) {
            case 15:
                return 10.0;
            case 30:
                return 16.0;
            default: //para tamanos invalidos
                return 10.0;
        }
    }
    
}
