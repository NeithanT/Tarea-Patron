/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.subguey;

public class Subguey {

    public static void main(String[] args) {
        System.out.println("Iniciando Subguey...");

        //sacar la GUI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.out.println("Creando pantalla");
                Pantalla refPantalla = new Pantalla();
                refPantalla.setVisible(true);
                System.out.println("Pantalla mostrada!");
            }
        });
    }
}
