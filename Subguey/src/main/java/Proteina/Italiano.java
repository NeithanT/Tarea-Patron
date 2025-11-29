/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proteina;

import com.mycompany.subguey.Sandwich;

public class Italiano extends Sandwich{
    
    //CONSTRUCTOR
    public Italiano(int tamano) {
        super("Italiano", tamano, calcularPrecio(tamano));
    }

    private static double calcularPrecio(int tamano) {
        switch (tamano) {
            case 15:
                return 9.0;
            case 30:
                return 16.0;
            default: //para tamanos invalidos
                return 9.0;
        }
    }
    
}
