/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proteina;

import com.mycompany.subguey.Sandwich;

public class Atun extends Sandwich{
    //CONSTRUCTOR
    public Atun(int tamano) {
        super("Atun", tamano, calcularPrecio(tamano));
    }

    private static double calcularPrecio(int tamano) {
        switch (tamano) {
            case 15:
                return 11.0;
            case 30:
                return 17.0;
            default: //para tamanos invalidos
                return 11.0;
        }
    }
}
